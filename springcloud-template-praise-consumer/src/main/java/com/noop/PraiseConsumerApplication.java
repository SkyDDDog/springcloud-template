package com.noop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 主启动类
 */
@EnableDiscoveryClient
@SpringBootApplication
public class PraiseConsumerApplication {
    public static void main(String[] args) {
        SpringApplication.run(PraiseConsumerApplication.class, args);
    }
}