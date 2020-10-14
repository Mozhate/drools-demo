package com.laher.drools.test;

import com.laher.drools.boot.DroolsSpringBootApplication;
import com.laher.drools.boot.model.Discount;
import com.laher.drools.boot.model.Item;
import com.laher.drools.boot.model.Order;
import com.laher.drools.boot.service.CustomerServices;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * 测试用例
 * <p>
 *
 * @author laher
 * @version 1.0.0
 * @date 2020/10/13
 */
@RunWith(value = SpringRunner.class)
@SpringBootTest(classes = DroolsSpringBootApplication.class)
public class DroolsTest {

    @Resource
    private CustomerServices customerServices;

    @Test
    public void test1() {
        Item item1 = new Item("洗发水", 50);
        Item item2 = new Item("瓷碗", 150);

        Order order = new Order().add(item1, item2);
        Discount discount = new Discount(200, 20);

        customerServices.invoicing(order, discount);
        // 消费：200，优惠：20，实际支付：180
    }

}
