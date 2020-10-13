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

    private String user = "kieserver";
    private String password = "kieserver1!";

    @Bean
    @ConditionalOnMissingBean(KieServicesClient.class)
    public KieServicesClient kieServicesClient() {
        String serverUrl = "http://192.168.50.44:8180/kie-server/services/rest/server";
        KieServicesConfiguration configuration =
            KieServicesFactory.newRestConfiguration(serverUrl, user, password, 10000L);
        configuration.setMarshallingFormat(MarshallingFormat.JSON);
        return KieServicesFactory.newKieServicesClient(configuration);
    }
}
