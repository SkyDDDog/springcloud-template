package com.noop.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

/**
 * 账户交互类
 *
 * @author 天狗
 * @version 1.0
 * @date 2024/1/25 22:26
 */
@Data
public class AccountDTO {

    @Schema(description = "用户id")
    @NotBlank(message = "用户id不能为空")
    private String userId;

    @Schema(description = "金额")
    @NotBlank
    private Integer price;

}
