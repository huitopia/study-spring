package com.study.controller;

import com.study.domain.MyBean281Customer;
import com.study.domain.MyBean283Employees;
import com.study.mapper.Mapper03;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequiredArgsConstructor
@RequestMapping("main32")
public class Controller32 {
    private final Mapper03 mapper;

    @GetMapping("sub1")
    public void method1() {
        int rowCount = mapper.deleteOneCustomer();
        System.out.println(rowCount + "명 고객 삭제");
    }

    @GetMapping("sub2")
    public void method2(Integer id) {
        int rowCount = mapper.deleteOneCustomerById(id);
        System.out.println(rowCount + "명 고객 삭제");
    }

    // todo: /main32/sub3?eid=2
    //  2번 직원 삭제하는 메소드와 mapper에 메소드 작성하기
    @GetMapping("sub3")
    public void method3(Integer eid) {
        int rowCount = mapper.deleteOneCustomerById1(eid);
        if (rowCount > 0) {
            System.out.println(eid + "번 직원 삭제 완료");
        } else {
            System.out.println("삭제 실패");
        }
    }

    // name=chae&contactName=geumjjok&city=seoul&country=korea&address=gangseo
    @GetMapping("sub4")
    public void method4(MyBean281Customer customer) {
        int i = mapper.insertCustomer(customer);
        System.out.println(i);
    }

    // todo: 직원 입력 코드 작성
    // lastName=chaechae&firstName=jjok&birthDate=1998-08-12&photo=pic2223&notes=dsfsdjfkjwekrjsd
    @GetMapping("sub5")
    public void method5() {
    }

    @PostMapping("sub5")
    public String method6(MyBean283Employees employee,
                          RedirectAttributes rttr) {
        int i = mapper.insertEmployee(employee);
        if (i > 0) {
            rttr.addFlashAttribute("message", "Create Success");
        } else {
            rttr.addFlashAttribute("message", "Create Fail");
        }
        return "redirect:/main32/sub5";
    }

    @GetMapping("sub6")
    public void method6(@RequestParam(value = "id",required = false)
                        ) {

    }
}
