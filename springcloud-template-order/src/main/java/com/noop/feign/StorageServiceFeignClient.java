package com.noop.feign;

import com.noop.common.CommonResult;
import com.noop.feign.dto.StorageDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author 天狗
 * @version 1.0
 * @date 2024/1/25 22:46
 */
@FeignClient(name = "module-storage")
public interface StorageServiceFeignClient {

    @PostMapping("/storage/reduce-stock")
    CommonResult reduceStock(@RequestBody StorageDTO productReduceStockDTO);

}
