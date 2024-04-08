package com.study.domain;

public class MyBean091 {
    // name, age 속성(property) 가 있음
    /* JavaBean Property Name
     * propertyName = getter, setter의 methodName로 부터 결정
     * get, set을 제거하고 앞글자를 소문자로 변경한 것
     * jsp에서 호출 시 getName x / name o
     */
    public String getName() {
        return "hui";
    }

    public Integer getAge() {
        return 30;
    }
}
