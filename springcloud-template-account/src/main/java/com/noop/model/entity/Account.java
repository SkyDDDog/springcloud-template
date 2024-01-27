package com.noop.model.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.noop.util.orm.DataEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serial;

/**
 * 账户表
 *
 * @author 天狗
 * @version 1.0
 * @date 2024/1/25 22:00
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Accessors(chain = true)
@TableName("account")
@ToString(callSuper = true)
public class Account extends DataEntity<Account>{
    @Serial
    private static final long serialVersionUID = 7221514452338342041L;

    private String userId;

    private Integer money;

}
