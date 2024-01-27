package com.noop.service;

import com.noop.exception.BusinessException;

/**
 * 库存服务接口类
 *
 * @author 天狗
 * @version 1.0
 * @date 2024/1/25 19:40
 */
public interface StorageService {

    /**
     * 扣减库存
     * @param commodityCode 商品编号
     * @param orderCount    订单数量
     * @throws BusinessException    业务异常
     */
    void reduceStock(String commodityCode, Integer orderCount) throws BusinessException;

    /**
     * 获取剩余库存
     * @param commodityCode 商品编号
     * @return  剩余库存
     */
    int getRemainCount(String commodityCode);

}
