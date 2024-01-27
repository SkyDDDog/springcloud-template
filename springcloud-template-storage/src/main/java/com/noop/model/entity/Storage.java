package com.noop.model.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.noop.util.orm.DataEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serial;

/**
 * 库存表
 *
 * @author 天狗
 * @version 1.0
 * @date 2024/1/25 19:37
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Accessors(chain = true)
@TableName("storage")
@ToString(callSuper = true)
public class Storage extends DataEntity<Storage> {

    @Serial
    private static final long serialVersionUID = 7195130756429342931L;

    private String commodityCode;

    private int count;

}
