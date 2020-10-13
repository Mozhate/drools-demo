package com.laher.drools.boot.model;

import java.util.Arrays;
import java.util.List;

/**
 * 订单
 * <p>
 *
 * @author laher
 * @version 1.0.0
 */
public class Order {
    /** 消费金额 **/
    private Integer money = 0;
    /** 优惠金额 **/
    private Integer preferentialMoney = 0;
    /** 实际消费金额 **/
    private Integer actualMoney = 0;
    /** 购物列表 **/
    private List<Item> items;

    public Order add(Item... items) {
        this.items = Arrays.asList(items);
        return this;
    }

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

    public Integer getActualMoney() {
        return actualMoney;
    }

    public void setActualMoney(Integer actualMoney) {
        this.actualMoney = actualMoney;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}
