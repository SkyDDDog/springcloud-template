package com.noop.controller;

import com.noop.model.message.PraiseMessage;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.web.bind.annotation.*;

/**
 * 点赞控制器
 *
 * @author 天狗
 * @version 1.0
 * @date 2024/1/25 16:24
 */
@Tag(name = "PraiseController", description = "点赞控制器")
@Slf4j
@CrossOrigin("*")
@RestController()
@RequestMapping(value = "/praise")
public class PraiseController {

    /**
     * 绑定名称,对应配置中的 ${spring.cloud.stream.bindings.praise-output}
     */
    private static final String BINDING_NAME = "praise-output";

    @Autowired
    private StreamBridge streamBridge;

    @Operation(summary = "点赞")
    @Parameters({
            @Parameter(name = "id", description = "点赞ID")
    })
    @GetMapping({ "/rocketmq", "/sentinel" })
    public boolean praise(@RequestParam String id) {
        PraiseMessage message = new PraiseMessage();
        message.setId(id);
        Message<PraiseMessage> praiseMessage = MessageBuilder.withPayload(message)
                .build();
        return streamBridge.send(BINDING_NAME, praiseMessage);
    }


}
