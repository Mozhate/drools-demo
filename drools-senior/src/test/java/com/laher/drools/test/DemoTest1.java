package com.laher.drools.test;

import com.laher.drools.DroolsSeniorApplication;
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
     * 相同类型的产品满足200减30优惠
     */
    @Test
    public void test1() {
        // 初始化数据
        customerServices.test1(generatorOrder());
    }

    private Order generatorOrder() {
        Item item1 = new Item("洗发水", "生活类", 60);
        Item item2 = new Item("瓷碗", "生活类", 140);

        return new Order().add(item1, item2);
    }
}
