package com.laher.drools.entity;

import lombok.Data;

/**
 * @author laher
 * @version 1.0.0
 */
@Data
public class Consumption {

    /** 消费金额 **/
    private Integer money;

    /** 减免金额 **/
    private Integer reduce;

    /** 实际消费金额 = 消费金额 - 减免金额 **/
    private Integer totalMoney;

    public Consumption(Integer money) {
        this.money = money;
    }

    public Consumption() {
    }
}
