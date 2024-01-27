package com.noop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 主启动类
 */
@SpringBootApplication
@EnableDiscoveryClient
public class PraiseProviderApplication {
    public static void main(String[] args) {
        SpringApplication.run(PraiseProviderApplication.class, args);
    }
}