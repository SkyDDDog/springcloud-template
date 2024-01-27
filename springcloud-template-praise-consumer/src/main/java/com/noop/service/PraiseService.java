package com.noop.service;

import org.springframework.stereotype.Service;

/**
 * 点赞服务
 *
 * @author 天狗
 * @version 1.0
 * @date 2024/1/25 16:41
 */
public interface PraiseService {

    /**
     * 点赞
     * @param id    被点赞的对象id
     */
    void praiseItem(String id);

    /**
     * 获取点赞数
     * @param id    被点赞的对象id
     * @return    点赞数
     */
    int getPraise(String id);
}
