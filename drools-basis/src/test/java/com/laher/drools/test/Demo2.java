package com.laher.drools.test;

import com.laher.drools.entity.Consumption;
import org.kie.api.KieServices;
import org.kie.api.command.Command;
import org.kie.api.command.KieCommands;
import org.kie.api.runtime.ExecutionResults;

import org.kie.server.api.marshalling.MarshallingFormat;
import org.kie.server.api.model.ServiceResponse;
import org.kie.server.client.KieServicesClient;
import org.kie.server.client.KieServicesConfiguration;
import org.kie.server.client.KieServicesFactory;
import org.kie.server.client.RuleServicesClient;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * <p>
 *
 * @author laher
 * @version 1.0.0
 */
public class Demo2 {

    public static void main(String[] args) {
        new Demo2().run();
    }

    // 远程服务
    private static final String SERVER_URL = "http://192.168.50.44:8180/kie-server/services/rest/server";

    // 账户
    private static final String USERNAME = "kieserver";

    // 密码
    private static final String PASSWORD = "kieserver1!";

    // 容器进程包
    private static final String KIE_CONTAINER_ID = "drools-basis_1.0.0-SNAPSHOT";

    // session
    private static final String KIE_SESSION_ID = "ksession2";

    private void run() {
        // 连接信息
        KieServicesConfiguration kieServicesConfiguration =
            KieServicesFactory.newRestConfiguration(SERVER_URL, USERNAME, PASSWORD, 10000L);
        kieServicesConfiguration.setMarshallingFormat(MarshallingFormat.JSON);

        // 获取规则服务客户端
        KieServicesClient kieServicesClient = KieServicesFactory.newKieServicesClient(kieServicesConfiguration);
        RuleServicesClient ruleServicesClient = kieServicesClient.getServicesClient(RuleServicesClient.class);

        // 执行命令
        KieCommands kieCommands = KieServices.Factory.get().getCommands();
        List<Command<?>> commands = new LinkedList<Command<?>>();

        // 执行对象
        Consumption c = new Consumption(200);
        commands.add(kieCommands.newInsert(c, "Consumption"));

        // 执行运行规则命令
        commands.add(kieCommands.newFireAllRules());

        // 规则执行
        ServiceResponse<ExecutionResults> results = ruleServicesClient.executeCommandsWithResults(KIE_CONTAINER_ID,
            kieCommands.newBatchExecution(commands, KIE_SESSION_ID));

        // 获取结果
        Consumption res = (Consumption)results.getResult().getValue("Consumption");
        System.out.println(res.getMoney() + " - " + res.getReduce() + " = " + res.getTotalMoney());

        // 输出结果
        // 200 - 80 = 120

        // 配置都交给远程服务端，而系统只负责数据传输。
        // 而服务端配置Maven后公用私服，则只用编写一个实体。
        // 当前需要在服务端和项目中配置，较为繁琐。
    }
}
