package com.noop.service;

import com.noop.exception.BusinessException;

/**
 * 订单服务接口类
 *
 * @author 天狗
 * @version 1.0
 * @date 2024/1/25 22:40
 */
public interface OrderService {

    /**
     * 创建订单
     * @param userId    用户id
     * @param commodityCode 商品编码
     * @param count 数量
     * @throws BusinessException    业务异常
     */
    void createOrder(String userId, String commodityCode, Integer count)
            throws BusinessException;

}
