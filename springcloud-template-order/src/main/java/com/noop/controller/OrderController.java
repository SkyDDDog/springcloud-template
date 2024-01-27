package com.noop.controller;

import com.noop.common.CommonResult;
import com.noop.exception.BusinessException;
import com.noop.service.OrderService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 订单控制器
 *
 * @author 天狗
 * @version 1.0
 * @date 2024/1/25 22:54
 */
@Tag(name = "OrderController", description = "订单控制器")
@SecurityRequirement(name = "Bearer Authentication")
@Slf4j
@CrossOrigin("*")
@RestController()
@RequestMapping(value = "/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Operation(summary = "创建订单")
    @Parameters({
            @Parameter(name = "userId", description = "用户id", required = true),
            @Parameter(name = "commodityCode", description = "商品编码", required = true),
            @Parameter(name = "count", description = "数量", required = true)
    })
    @PostMapping("/")
    public CommonResult createOrder(@RequestParam("userId") String userId,
                                    @RequestParam("commodityCode") String commodityCode,
                                    @RequestParam("count") Integer count) {
        CommonResult result = new CommonResult().init();
        try {
            orderService.createOrder(userId, commodityCode, count);
        }
        catch (BusinessException e) {
            return (CommonResult) result.failCustom(e.getMessage()).end();
        }
        return (CommonResult) result.success().end();
    }

}
