package com.noop.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.noop.exception.BusinessException;
import com.noop.mapper.StorageMapper;
import com.noop.model.entity.Storage;
import com.noop.service.StorageService;
import com.noop.util.orm.CrudService;
import io.seata.core.context.RootContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;

/**
 * 库存服务实现类
 *
 * @author 天狗
 * @version 1.0
 * @date 2024/1/25 19:42
 */
@Slf4j
@Service
public class StorageServiceImpl extends CrudService<StorageMapper, Storage> implements StorageService {

    @Override
    public void reduceStock(String commodityCode, Integer orderCount) throws BusinessException {
        log.info("[reduceStock] current XID: {}", RootContext.getXID());
        QueryWrapper<Storage> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(Storage::getCommodityCode, commodityCode)
                .ge(Storage::getCount, orderCount);
        List<Storage> list = this.findList(wrapper);
        if (CollectionUtils.isEmpty(list)) {
            throw new BusinessException("no enough stock");
        } else {
            Storage storage = list.get(0);
            storage.setCount(storage.getCount() - orderCount);
            this.save(storage);
        }
    }

    @Override
    public int getRemainCount(String commodityCode) {
        QueryWrapper<Storage> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(Storage::getCommodityCode, commodityCode);
        List<Storage> list = this.findList(wrapper);
        if (!CollectionUtils.isEmpty(list)) {
            return list.get(0).getCount();
        }
        return 0;
    }
}
