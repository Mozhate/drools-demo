package com.laher.drools.boot.service;

import javax.annotation.Resource;

import org.kie.api.KieServices;
import org.kie.api.command.Command;
import org.kie.api.command.KieCommands;
import org.kie.api.runtime.ExecutionResults;
import org.kie.api.runtime.KieSession;
import org.kie.server.api.model.ServiceResponse;
import org.kie.server.client.KieServicesClient;
import org.kie.server.client.RuleServicesClient;
import org.springframework.stereotype.Service;

import com.laher.drools.boot.dto.Discount;
import com.laher.drools.boot.dto.Order;

import java.util.LinkedList;
import java.util.List;

/**
 * @author laher
 * @date 2020/10/8/008
 */
@Service
public class CustomerServices {

    @Resource
    private KieServicesClient kieServicesClient;

    private String containerId = "drools-spring-boot_1.0.0-SNAPSHOT";

    public void invoicing(Order order, Discount discount) {
        // 获取规则服务客户端
        RuleServicesClient ruleServicesClient = kieServicesClient.getServicesClient(RuleServicesClient.class);

        // 执行命令
        KieCommands kieCommands = KieServices.Factory.get().getCommands();
        List<Command<?>> commands = new LinkedList<Command<?>>();
        commands.add(kieCommands.newInsert(order, "Order"));
        commands.add(kieCommands.newInsert(discount));
        commands.add(kieCommands.newFireAllRules());

        // 规则执行
        ServiceResponse<ExecutionResults> results = ruleServicesClient.executeCommandsWithResults(containerId,
            kieCommands.newBatchExecution(commands, "ksession1"));

        Order res = (Order)results.getResult().getValue("Order");

        System.out
            .println("消费：" + res.getMoney() + "，优惠：" + res.getPreferentialMoney() + "，实际支付：" + res.getActualMoney());
    }
}
