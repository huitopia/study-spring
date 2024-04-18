package com.study.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MyBean261Order {
    private Integer id;
    private Integer customerId;
    private Integer employeeId;
    private String date;
    private Integer shipperId;
}
