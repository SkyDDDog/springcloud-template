package com.noop.feign.dto;

import lombok.Data;

/**
 * 库存DTO
 *
 * @author 天狗
 * @version 1.0
 * @date 2024/1/25 21:06
 */
@Data
public class StorageDTO {

    private String commodityCode;

    private Integer count;

}
