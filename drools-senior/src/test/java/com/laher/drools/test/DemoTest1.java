package com.laher.drools.test;

import com.laher.drools.DroolsSeniorApplication;
import com.laher.drools.entity.Discount;
import com.laher.drools.entity.Item;
import com.laher.drools.entity.Order;
import com.laher.drools.service.CustomerServices;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @author laher
 * @date 2020/10/8/008
 */
@RunWith(value = SpringRunner.class)
@SpringBootTest(classes = DroolsSeniorApplication.class)
public class DemoTest1 {

    @Resource
    private CustomerServices customerServices;

    /**
     * 满足200减30优惠
     */
    @Test
    public void test1() {
        // 初始化数据
        customerServices.test1(generatorOrder1());
        customerServices.test1(generatorOrder2());
        // 输出结果：
        // 消费：155，优惠：0，实际支付：155
        // 消费：205，优惠：30，实际支付：175
    }

    private Order generatorOrder1() {
        Item item1 = new Item("洗发水", 15);
        Item item2 = new Item("瓷碗", 140);

        return new Order().add(item1, item2);
    }

    private Order generatorOrder2() {
        Item item1 = new Item("洗发水", 65);
        Item item2 = new Item("瓷碗", 140);

        return new Order().add(item1, item2);
    }

    /**
     * 获取优惠
     * 
     * @return 结果
     */
    private Discount generatorDiscount() {
        return new Discount(200, 20);
    }

    /**
     * 满足200减20优惠
     */
    @Test
    public void test2() {
        // 初始化数据
        customerServices.test2(generatorOrder1(), generatorDiscount());
        customerServices.test2(generatorOrder2(), generatorDiscount());
        // 输出结果：
        // 消费：155，优惠：0，实际支付：155
        // 消费：205，优惠：20，实际支付：185
    }

}
