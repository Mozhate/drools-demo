package com.laher.drools.test;

import com.laher.drools.entity.Customer;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

/**
 * <p>
 *
 * @author laher
 * @version 1.0.0
 */
public class Demo1 {

    public static void main(String[] args) {
        new Demo1().run();
    }

    private void run() {
        // kmodule.xml文件是用于选择KIE基础资源并配置这些KIE基础和会话的描述文件
        // 且文件必须放置在Maven项目的resources / META-INF文件夹中
        // 所有其他Kie构件必须存储在resources文件夹或它下面的任何其他子文件夹中
        KieServices kieServices = KieServices.Factory.get();
        // 从类路径创建一个KieContainer
        KieContainer kieContainer = kieServices.getKieClasspathContainer();
        // 获取"ksession1"环境下kieSession实例
        KieSession kieSession = kieContainer.newKieSession("ksession1");
        kieSession.insert(new Customer("张三", 230));
        kieSession.insert(new Customer("李四", 0));
        kieSession.insert(new Customer("王五", 80));
        // 运行所有规则
        kieSession.fireAllRules();
        // 整个业务由drools支撑，数据由程序提供
    }
}
