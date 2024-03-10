package com.sky.service;

import com.sky.dto.DishDTO;

/**
 * @author Zz
 * @version 1.0
 * @description:
 * @date 2024/3/9 19:22
 */
public interface DishService {


    /**
     * 新增菜品和口味数据
     * @param dishDTO
     */
    public void saveWithFlavor(DishDTO dishDTO);

}
