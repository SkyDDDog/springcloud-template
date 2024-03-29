package com.noop.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 鉴权白名单
 *
 * @author 天狗
 * @version 1.0
 * @date 2024/1/24 22:21
 */

@Data
@Component
@ConfigurationProperties(prefix = "auth.ignore")
public class AuthWhiteListProperties {

    private List<String> whites;

}
