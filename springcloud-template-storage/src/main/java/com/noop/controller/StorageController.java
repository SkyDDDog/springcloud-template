package com.noop.controller;

import com.noop.common.CommonResult;
import com.noop.common.MsgCodeUtil;
import com.noop.model.dto.StorageDTO;
import com.noop.service.StorageService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 库存控制器
 *
 * @author 天狗
 * @version 1.0
 * @date 2024/1/25 21:04
 */
@Tag(name = "StorageController", description = "库存控制器")
@SecurityRequirement(name = "Bearer Authentication")
@Slf4j
@CrossOrigin("*")
@RestController()
@RequestMapping(value = "/storage")
public class StorageController {

    @Autowired
    private StorageService storageService;

    @PostMapping(value = "/reduce-stock")
    public CommonResult reduceStock(@RequestBody StorageDTO dto) {
        CommonResult result = new CommonResult().init();
        try {
            storageService.reduceStock(dto.getCommodityCode(), dto.getCount());
            result.success();
        } catch (Exception e) {
            log.error("库存扣减失败", e);
            result.failCustom(MsgCodeUtil.MSC_DATA_UPDATADATA_ERROR, "库存扣减失败");
        }
        return (CommonResult) result.end();
    }

    @GetMapping(value = "/")
    public CommonResult getRemainCount(String commodityCode) {
        CommonResult result = new CommonResult().init();
        try {
            result.success("storage", storageService.getRemainCount(commodityCode));
        } catch (Exception e) {
            log.error("获取库存失败", e);
            result.failCustom(MsgCodeUtil.MSG_CODE_DATA_NOT_EXIST, "获取库存失败");
        }
        return (CommonResult) result.end();
    }

}
