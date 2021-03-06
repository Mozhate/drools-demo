package com.laher.drools.boot.model;

/**
 * 物品
 * <p>
 *
 * @author laher
 * @version 1.0.0
 */
public class Item {
    /** 名称 **/
    private String name;
    /** 金额 **/
    private Integer money;

    public Item(String name, Integer money) {
        this.name = name;
        this.money = money;
    }

    public Item() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }
}
