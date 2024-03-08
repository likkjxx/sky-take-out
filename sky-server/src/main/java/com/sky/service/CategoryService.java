package com.sky.service;

import com.sky.dto.CategoryDTO;
import org.springframework.stereotype.Service;

/**
 * @Author:zjj
 * @date:2024/3/8 9:11
 * @Description:
 */
public interface CategoryService {
    /**
     * 新增分类
     * @param categoryDTO
     */
    void save(CategoryDTO categoryDTO);
}
