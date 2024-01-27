package com.noop.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.noop.model.entity.Order;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author 天狗
 * @version 1.0
 * @date 2024/1/25 22:40
 */
@Mapper
public interface OrderMapper extends BaseMapper<Order> {
}
