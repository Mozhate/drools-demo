package com.laher.drools.service;

import com.laher.drools.entity.Customer;
import org.kie.api.cdi.KSession;
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

    public void fire(Customer customer) {
        kieSession.insert(customer);
        kieSession.fireAllRules();
    }
}
