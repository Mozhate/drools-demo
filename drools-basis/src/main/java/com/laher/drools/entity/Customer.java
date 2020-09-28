package com.laher.drools.entity;

import lombok.Data;

/**
 * 客户
 * <p>
 *
 * @author laher
 * @version 1.0.0
 */
@Data
public class Customer {
    /** 姓名 **/
    private String name;
    /** 消费金额 **/
    private Integer money;

    public Customer(String name, Integer money) {
        this.name = name;
        this.money = money;
    }

    public Customer() {}
}
