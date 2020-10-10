package com.laher.drools.service;

import com.laher.drools.entity.Item;
import com.laher.drools.entity.Order;
import org.kie.api.runtime.KieSession;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author laher
 * @date 2020/10/8/008
 */
@Service
public class CustomerServices {

    @Resource
    private KieSession kieSession;

    public void test1(Order order) {
        kieSession.insert(order);
        kieSession.fireAllRules();

        System.out.println(
            "消费：" + order.getMoney() + "，优惠：" + order.getPreferentialMoney() + "，实际支付：" + order.getActualMoney());
    }
}
