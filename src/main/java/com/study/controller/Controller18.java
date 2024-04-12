package com.study.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;

@Controller
@RequestMapping("main18")
public class Controller18 {
    @RequestMapping("sub1") // iphone
    public void sub1(String product, Integer quantity, HttpSession session) {
        addCart(product, quantity, session);

    }

    @RequestMapping("sub2") // mac
    public void sub2(String product, Integer quantity, HttpSession session) {
        addCart(product, quantity, session);
    }

    @RequestMapping("sub3") // macbook
    public void sub3(String product, Integer quantity, HttpSession session) {
        addCart(product, quantity, session);
    }

    @RequestMapping("sub4") // cart
    public void sub4() {
    }

    private static void addCart(String product, Integer quantity, HttpSession session) {
        if (quantity == null) { // 수량이 없으면
            return;
        }
        // HashMap 생성 후 session cart 값 받기
        HashMap<String, Integer> cart = (HashMap<String, Integer>) session.getAttribute("cart");
        if (cart == null) { // cart 값이 없으면
            cart = new HashMap<String, Integer>(); // cart HashMap 생성
            session.setAttribute("cart", cart); // 위에 생성된 cart 로 session 속성 변경
        }
        if (cart.containsKey(product)) { // cart key 값이 product 를 포함하면
            Integer oldQuantity = cart.get(product); // key(product) 의 value(quantity) 값을 oldQuantity 에 담아줌
            int newQuantity = oldQuantity + quantity;
            cart.put(product, newQuantity); // key(product) 의 value(quantity) 값을 신규로 수정
        } else { // cart key 값이 product 를 포함하지 않으면 신규로 cart 에 담기
            cart.put(product, quantity);
        }
    }
}
