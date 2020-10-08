package com.laher.drools.test;

import com.laher.drools.DroolsSeniorApplication;
import com.laher.drools.entity.Customer;
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
    public void test1(){
        customerServices.fire(new Customer("张三", 230));
        customerServices.fire(new Customer("李四", 0));
        customerServices.fire(new Customer("王五", 80));
    }
}
