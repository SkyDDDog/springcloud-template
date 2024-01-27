package com.noop.service;

import com.noop.exception.BusinessException;

/**
 * 账户服务接口类
 *
 * @author 天狗
 * @version 1.0
 * @date 2024/1/25 22:03
 */
public interface AccountService {

    /**
     * 扣减余额
     * @param userId    用户id
     * @param price    价格
     * @throws BusinessException    业务异常
     */
    void reduceBalance(String userId, Integer price) throws BusinessException;

    /**
     * 获取账户剩余金额
     * @param userId    用户id
     * @return  账户剩余金额
     */
    int getRemainAccount(String userId);

}
