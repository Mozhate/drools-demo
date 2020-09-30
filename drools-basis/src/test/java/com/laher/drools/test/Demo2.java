package com.laher.drools.test;

import org.kie.api.KieServices;
import org.kie.api.command.Command;
import org.kie.api.command.KieCommands;
import org.kie.api.runtime.ExecutionResults;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import com.laher.drools.entity.Customer;
import org.kie.server.api.marshalling.MarshallingFormat;
import org.kie.server.api.model.ServiceResponse;
import org.kie.server.client.KieServicesClient;
import org.kie.server.client.KieServicesConfiguration;
import org.kie.server.client.KieServicesFactory;
import org.kie.server.client.RuleServicesClient;

import java.util.LinkedList;
import java.util.List;

/**
 * <p>
 *
 * @author laher
 * @version 1.0.0
 */
public class Demo2 {

    /** 服务地址 **/
    public static final String SERVER_URL = "http://192.168.50.44:8180/kie-server/services/rest/server";
    /** 账户 **/
    public static final String USERNAME = "kieserver";
    /** 密码 **/
    public static final String PASSWORD = "kieserver1!";
    /** 密码 **/
    public static final String KIE_CONTAINER_ID = "drools-basis_1.0.0-SNAPSHOT";
    /** 密码 **/
    public static final String KIE_SESSION_ID = "ksession2";

    public static void main(String[] args) {
        new Demo2().run();
    }

    private void run() {
        // KisService 配置信息设置
        KieServicesConfiguration kieServicesConfiguration =
                KieServicesFactory.newRestConfiguration(SERVER_URL, USERNAME, PASSWORD, 10000L);
        kieServicesConfiguration.setMarshallingFormat(MarshallingFormat.JSON);

        // 创建规则服务客户端
        KieServicesClient kieServicesClient = KieServicesFactory.newKieServicesClient(kieServicesConfiguration);
        RuleServicesClient ruleServicesClient = kieServicesClient.getServicesClient(RuleServicesClient.class);

        // 命令定义，包含插入数据，执行规则
        KieCommands kieCommands = KieServices.Factory.get().getCommands();
        List<Command<?>> commands = new LinkedList<Command<?>>();
        commands.add(kieCommands.newInsert(new Customer("张三", 230),"Customer"));
        commands.add(kieCommands.newInsert(new Customer("李四", 0),"Customer"));
        commands.add(kieCommands.newInsert(new Customer("王五", 80),"Customer"));
        commands.add(kieCommands.newFireAllRules());
        ServiceResponse<ExecutionResults> results = ruleServicesClient.executeCommandsWithResults(KIE_CONTAINER_ID,
                kieCommands.newBatchExecution(commands, KIE_SESSION_ID));

        ExecutionResults res = results.getResult();

        System.out.println(results.getResult()== null);
    }
}
