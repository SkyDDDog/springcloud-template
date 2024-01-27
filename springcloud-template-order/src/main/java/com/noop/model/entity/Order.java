package com.noop.model.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.noop.util.orm.DataEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serial;

/**
 * 订单表
 *
 * @author 天狗
 * @version 1.0
 * @date 2024/1/25 22:38
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Accessors(chain = true)
@TableName("order")
@ToString(callSuper = true)
public class Order extends DataEntity<Order> {

    @Serial
    private static final long serialVersionUID = 2154627379522268089L;

    private String userId;

    private String commodityCode;

    private Integer count;

    private Integer money;

}
