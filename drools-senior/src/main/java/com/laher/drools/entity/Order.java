package com.laher.drools.entity;

import lombok.Data;

import java.util.Arrays;
import java.util.List;

/**
 * 订单
 * <p>
 *
 * @author laher
 * @version 1.0.0
 */
@Data
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
        Arrays.stream(items).forEach(item -> {
            money += item.getMoney();
        });
        this.items = Arrays.asList(items);
        return this;
    }
}
