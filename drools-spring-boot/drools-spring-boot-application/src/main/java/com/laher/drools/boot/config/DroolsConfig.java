package com.laher.drools.boot.config;

import org.kie.server.api.marshalling.MarshallingFormat;
import org.kie.server.client.KieServicesClient;
import org.kie.server.client.KieServicesConfiguration;
import org.kie.server.client.KieServicesFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author laher
 */
@Configuration
public class DroolsConfig {

    private String USER = "kieserver";
    private String PWD = "kieserver1!";
    private String SERVER_URL = "http://192.168.50.44:8180/kie-server/services/rest/server";

    @Bean
    @ConditionalOnMissingBean(KieServicesClient.class)
    public KieServicesClient kieServicesClient() {
        KieServicesConfiguration configuration =
            KieServicesFactory.newRestConfiguration(SERVER_URL, USER, PWD, 10000L);
        configuration.setMarshallingFormat(MarshallingFormat.JSON);
        return KieServicesFactory.newKieServicesClient(configuration);
    }
}
