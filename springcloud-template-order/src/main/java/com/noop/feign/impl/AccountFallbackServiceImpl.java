package com.noop.feign.impl;

import com.noop.common.CommonResult;
import com.noop.feign.AccountServiceFeignClient;
import com.noop.feign.dto.AccountDTO;
import org.springframework.stereotype.Component;

/**
 * AccountServiceFeignClient 服务调用失败处理类
 *
 * @author 天狗
 * @version 1.0
 * @date 2024/1/27 13:10
 */
public class AccountFallbackServiceImpl implements AccountServiceFeignClient {

    @Override
    public CommonResult reduceBalance(AccountDTO accountReduceBalanceDTO) {
        return (CommonResult) new CommonResult().init().failCustom("调用账户服务失败").end();
    }
}
