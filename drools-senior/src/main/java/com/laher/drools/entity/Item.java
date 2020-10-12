package com.laher.drools.entity;

import lombok.Data;

/**
 * 物品
 * <p>
 *
 * @author laher
 * @version 1.0.0
 */
@Data
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
}
