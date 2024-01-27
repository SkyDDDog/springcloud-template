package com.noop.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.noop.exception.BusinessException;
import com.noop.mapper.AccountMapper;
import com.noop.model.entity.Account;
import com.noop.service.AccountService;
import com.noop.util.orm.CrudService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * 账户服务实现类
 *
 * @author 天狗
 * @version 1.0
 * @date 2024/1/25 22:05
 */
@Slf4j
@Service
public class AccountServiceImpl extends CrudService<AccountMapper, Account> implements AccountService {

    @Override
    public void reduceBalance(String userId, Integer price) throws BusinessException {
//        log.info("[reduceBalance] currenet XID: {}", RootContext.getXID());
        QueryWrapper<Account> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(Account::getUserId, userId)
                .ge(Account::getMoney, price);
        List<Account> list = this.findList(wrapper);
        if (CollectionUtils.isEmpty(list)) {
            throw new BusinessException("账户余额不足");
        }
        Account account = list.get(0);
        account.setMoney(account.getMoney() - price);
        if (this.save(account)<=0) {
            throw new BusinessException("扣减余额失败");
        }
    }

    @Override
    public int getRemainAccount(String userId) {
        QueryWrapper<Account> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(Account::getUserId, userId);
        List<Account> list = this.findList(wrapper);
        return CollectionUtils.isEmpty(list) ? 0 : list.get(0).getMoney();
    }
}
