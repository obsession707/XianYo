package com.xianyo.util.service;

import org.springframework.stereotype.Service;

/**
 * 随机生成id函数接口
 */
public interface IDGeneratorService {
    long  genetatorForOthers(int flag);
    int  generatorForAdmin();
}
