package com.noop.model.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.noop.util.orm.DataEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serial;

/**
 * @author 天狗
 * @version 1.0
 * @date 2024/1/25 16:40
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Accessors(chain = true)
@TableName("praise")
@ToString(callSuper = true)
public class Praise extends DataEntity<Praise> {

    @Serial
    private static final long serialVersionUID = -388819964993790670L;

    private int praise;

}
