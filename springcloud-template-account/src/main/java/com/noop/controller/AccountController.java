package com.noop.controller;

import com.noop.common.CommonResult;
import com.noop.exception.BusinessException;
import com.noop.model.dto.AccountDTO;
import com.noop.service.AccountService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * 账户控制器
 *
 * @author 天狗
 * @version 1.0
 * @date 2024/1/25 22:22
 */
@Tag(name = "AccountController", description = "账户控制器")
@SecurityRequirement(name = "Bearer Authentication")
@Slf4j
@CrossOrigin("*")
@RestController()
@RequestMapping(value = "/account")
public class AccountController {

    @Resource
    private AccountService accountService;

    @PostMapping("/reduce-balance")
    public CommonResult reduceBalance(@RequestBody AccountDTO dto) {
        CommonResult result = new CommonResult().init();
        try {
            accountService.reduceBalance(dto.getUserId(), dto.getPrice());
        } catch (BusinessException e) {
            return (CommonResult) result.failCustom(e.getMessage()).end();
        }
        return (CommonResult) result.success().end();
    }

    @GetMapping("/")
    public CommonResult getRemainAccount(String userId) {
        CommonResult result = new CommonResult().init();
        result.success("remain", accountService.getRemainAccount(userId));
        return (CommonResult) result.end();
    }

}
