package com.laher.drools.entity;

import lombok.Data;

/**
 * 优惠
 * <p>
 *
 * @author laher
 * @version 1.0.0
 */
@Data
public class Discount {
    /** 消费金额 **/
    private Integer money = 0;
    /** 优惠金额 **/
    private Integer preferentialMoney = 0;

    public Discount(Integer money, Integer preferentialMoney) {
        this.money = money;
        this.preferentialMoney = preferentialMoney;
    }

    public Discount() {}
}
