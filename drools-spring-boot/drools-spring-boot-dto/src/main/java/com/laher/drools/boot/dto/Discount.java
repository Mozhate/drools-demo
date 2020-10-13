package com.laher.drools.boot.dto;

/**
 * 优惠
 * <p>
 *
 * @author laher
 * @version 1.0.0
 */
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

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    public Integer getPreferentialMoney() {
        return preferentialMoney;
    }

    public void setPreferentialMoney(Integer preferentialMoney) {
        this.preferentialMoney = preferentialMoney;
    }
}
