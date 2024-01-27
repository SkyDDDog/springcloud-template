package com.noop.listener;

import com.noop.model.message.PraiseMessage;
import com.noop.service.PraiseService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.Message;

import java.util.function.Consumer;

/**
 * 监听器自动配置
 *
 * @author 天狗
 * @version 1.0
 * @date 2024/1/25 16:38
 */
@Configuration
public class ListenerAutoConfiguration {

    /**
     * 监听点赞消息
     * @param praiseService
     * @return
     */
    @Bean
    public Consumer<Message<PraiseMessage>> consumer(PraiseService praiseService) {
        return msg -> {
            praiseService.praiseItem(msg.getPayload().getId());
        };
    }

}
