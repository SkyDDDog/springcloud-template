package com.noop.service.impl;

import com.noop.mapper.PraiseMapper;
import com.noop.model.entity.Praise;
import com.noop.service.PraiseService;
import com.noop.util.orm.CrudService;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * 点赞服务实现类
 *
 * @author 天狗
 * @version 1.0
 * @date 2024/1/25 16:44
 */
@Service
public class PraiseServiceImpl extends CrudService<PraiseMapper, Praise> implements PraiseService {

    @Override
    public void praiseItem(String id) {
        Praise praise = this.get(id);
        praise.setPraise(praise.getPraise() + 1);
        this.save(praise);
    }

    @Override
    public int getPraise(String id) {
        Praise praise = this.get(id);
        return Objects.nonNull(praise)? praise.getPraise() : 0;
    }
}
