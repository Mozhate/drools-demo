package com.laher.drools;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author laher
 * @date 2020/10/8/008
 */
@SpringBootApplication(scanBasePackages = {"com.laher"})
@ComponentScan(value = {"com.laher.*.**"})
public class DroolsSeniorApplication {
    public static void main(String[] args) {
        SpringApplication.run(DroolsSeniorApplication.class,args);
    }

}
