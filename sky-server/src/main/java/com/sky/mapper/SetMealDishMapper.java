package com.sky.mapper;

import com.sky.annotation.AutoFill;
import com.sky.entity.Setmeal;
import com.sky.enumeration.OperationType;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author Zz
 * @version 1.0
 * @description:
 * @date 2024/3/10 14:00
 */
@Mapper
public interface SetMealDishMapper {

    /**
     * 根据菜品id查询套餐id
     * @param dishIds
     * @return
     */
    List<Long> getSetMealIdsByDishIds(List<Long> dishIds);

    /**
     * 根据套餐id更改销售状态
     * @param setMeal
     */
    @AutoFill(value = OperationType.UPDATE)
    void update(Setmeal setMeal);
}
