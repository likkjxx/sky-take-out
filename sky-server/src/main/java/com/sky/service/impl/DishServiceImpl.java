package com.sky.service.impl;

import com.sky.dto.DishDTO;
import com.sky.service.DishService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Zz
 * @version 1.0
 * @description:
 * @date 2024/3/9 19:22
 */
@Service
@Slf4j
public class DishServiceImpl implements DishService {

    /**
     * 新增菜品和口味数据
     * @param dishDTO
     */
    @Override
    @Transactional//事物注解，要么都成功要么都失败
    public void saveWithFlavor(DishDTO dishDTO) {

        //向菜品表插入1条数据

        //向口味表插入n条数据
    }
}
