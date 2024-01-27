package com.noop.service.impl;

import com.noop.common.CommonResult;
import com.noop.exception.BusinessException;
import com.noop.feign.AccountServiceFeignClient;
import com.noop.feign.StorageServiceFeignClient;
import com.noop.feign.dto.AccountDTO;
import com.noop.feign.dto.StorageDTO;
import com.noop.mapper.OrderMapper;
import com.noop.model.entity.Order;
import com.noop.service.OrderService;
import com.noop.util.orm.CrudService;
import io.seata.core.context.RootContext;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 订单服务实现类
 *
 * @author 天狗
 * @version 1.0
 * @date 2024/1/25 22:42
 */
@Slf4j
@Service
public class OrderServiceImpl extends CrudService<OrderMapper, Order> implements OrderService {

    @Autowired
    private AccountServiceFeignClient accountService;
    @Autowired
    private StorageServiceFeignClient storageService;

    @GlobalTransactional
    @Override
    public void createOrder(String userId, String commodityCode, Integer count) throws BusinessException {
        log.info("[createOrder] current XID: {}", RootContext.getXID());

        // deduct storage
        StorageDTO storageDTO = new StorageDTO();
        storageDTO.setCommodityCode(commodityCode);
        storageDTO.setCount(count);
        CommonResult storageResult = storageService.reduceStock(storageDTO);
        if (!storageResult.isSuccess()) {
            throw new BusinessException("stock not enough");
        }

        // deduct balance
        int price = count * 2;
        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setUserId(userId);
        accountDTO.setPrice(price);
        CommonResult accountResult = accountService.reduceBalance(accountDTO);
        if (!accountResult.isSuccess()) {
            throw new BusinessException("balance not enough");
        }

        // save order
        Order order = new Order();
        order.setUserId(userId)
                .setCommodityCode(commodityCode)
                .setCount(count)
                .setMoney(price);
        this.save(order);
        log.info("[createOrder] orderId: {}", order.getId());
    }
}
