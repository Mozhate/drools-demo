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
    /** 类型 **/
    private String type;
    /** 金额 **/
    private Integer money;

    public Item(String name, String type, Integer money) {
        this.name = name;
        this.type = type;
        this.money = money;
    }

    public Item() {}
}
