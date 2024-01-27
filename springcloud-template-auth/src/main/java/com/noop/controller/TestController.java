package com.noop.controller;

import com.noop.service.SysAuthService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试用
 *
 * @author 天狗
 * @version 1.0
 * @date 2024/1/24 16:49
 */
@Tag(name = "TestController", description = "测试中.gif")
@Slf4j
@CrossOrigin("*")
@RestController()
@RequestMapping(value = "/test")
public class TestController {

    @Resource
    private SysAuthService sysAuthService;


    @Operation(summary = "测试")
    @GetMapping(value = "")
    @SecurityRequirement(name = "Bearer Authentication")
    public String test() {
        return "test";
    }

    @Operation(summary = "生成测试用token,可用时长一个月")
    @GetMapping(value = "/token")
    public String token() {
        return sysAuthService.issueTestToken();
    }

}
