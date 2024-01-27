package com.noop.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.noop.model.entity.Account;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author 天狗
 * @version 1.0
 * @date 2024/1/25 22:02
 */
@Mapper
public interface AccountMapper extends BaseMapper<Account> {
}
