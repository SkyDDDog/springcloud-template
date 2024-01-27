package com.noop.feign;

import com.noop.common.CommonResult;
import com.noop.feign.dto.AccountDTO;
import com.noop.feign.impl.AccountFallbackServiceImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * 用户服务远程调用客户端
 *
 * @author 天狗
 * @version 1.0
 * @date 2024/1/25 22:44
 */
@FeignClient(name = "module-account", fallback = AccountFallbackServiceImpl.class)
public interface AccountServiceFeignClient {

    @PostMapping("/account/reduce-balance")
    CommonResult reduceBalance(@RequestBody AccountDTO accountReduceBalanceDTO);

}
