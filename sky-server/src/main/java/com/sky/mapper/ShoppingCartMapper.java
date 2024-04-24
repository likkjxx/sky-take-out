package com.sky.mapper;

import com.sky.entity.ShoppingCart;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @author Zz
 * @version 1.0
 * @description:
 * @date 2024/4/23 21:02
 */
@Mapper
public interface ShoppingCartMapper {

    /**
     * 动态条件查询
     * @param shoppingCart
     * @return
     */
    List<ShoppingCart> list(ShoppingCart shoppingCart);

    /**
     * 根据id修改商品数量
     * @param shoppingCart
     */
    @Update("update sky_take_out.shopping_cart set number = #{number} where id =#{id}")
    void updateNumberById(ShoppingCart shoppingCart);

    /**
     *插入购物车数据
     * @param shoppingCart
     */
    @Insert("insert into sky_take_out.shopping_cart (name, user_id, dish_id, setmeal_id, dish_flavor,number,amount,image,create_time) " +
            "VALUES (#{name},#{userId},#{dishId},#{setmealId},#{dishFlavor},#{number},#{amount},#{image},#{createTime}) ")
    void insert(ShoppingCart shoppingCart);
}
