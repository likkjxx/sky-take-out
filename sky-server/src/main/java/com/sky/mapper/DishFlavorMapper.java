package com.sky.mapper;

import com.sky.annotation.AutoFill;
import com.sky.entity.DishFlavor;
import com.sky.enumeration.OperationType;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author Zz
 * @version 1.0
 * @description:
 * @date 2024/3/10 10:49
 */
@Mapper
public interface DishFlavorMapper {
    /**
     * 批量插入口味数据
     * @param flavors
     */
    void insertBatch(List<DishFlavor> flavors);

    /**
     * 根据菜品id删除口味数据
     * @param dishId
     */
    @Delete("delete from sky_take_out.dish_flavor where dish_id = #{dishId}")
    void deleteByDishId(Long dishId);
}
