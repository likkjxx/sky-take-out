package com.sky.controller.admin;

import com.sky.dto.SetmealDTO;
import com.sky.dto.SetmealPageQueryDTO;
import com.sky.result.PageResult;
import com.sky.result.Result;
import com.sky.service.SetMealService;
import com.sky.vo.SetmealVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Zz
 * @version 1.0
 * @description: 套餐管理
 * @date 2024/3/11 10:36
 */
@RestController
@RequestMapping("/admin/setmeal")
@Api("套餐相关接口")
public class SetMealController {

    @Autowired
    private SetMealService setMealService;


    /**
     * 新增套餐
     * @param setmealDTO
     * @return
     */
    @PostMapping
    @ApiOperation("新增套餐")
    @CacheEvict(cacheNames = "setMealCache",key = "#setmealDTO.categoryId")
    public Result save(@RequestBody SetmealDTO setmealDTO){
        setMealService.saveWithDish(setmealDTO);
        return Result.success();
    }

    /**
     * 分页查询
     * @param setmealPageQueryDTO
     * @return
     */
    @GetMapping("/page")
    @ApiOperation("分页查询")
    public Result<PageResult> page(SetmealPageQueryDTO setmealPageQueryDTO){
        PageResult pageResult = setMealService.pageQuery(setmealPageQueryDTO);
        return Result.success(pageResult);
    }

    /**
     * 批量删除套餐
     * @param ids
     * @return
     */
    @DeleteMapping
    @ApiOperation("批量删除")
    @CacheEvict(cacheNames = "setMealCache",allEntries = true)
    public Result delete(@RequestParam List<Long> ids){
        setMealService.deleteBatch(ids);
        return Result.success();
    }

    /**
     * 根据id查询套餐
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    @ApiOperation("根据id查询套餐")
    public Result<SetmealVO> getById(@PathVariable Long id){
        SetmealVO setmealVO = setMealService.getByIdWithDish(id);
        return Result.success(setmealVO);
    }

    /**
     * 修改套餐
     * @param setmealDTO
     * @return
     */
    @PutMapping
    @ApiOperation("修改套餐")
    @CacheEvict(cacheNames = "setMealCache",allEntries = true)
    public Result update(@RequestBody SetmealDTO setmealDTO){
        setMealService.update(setmealDTO);
        return Result.success();
    }

    /**
     * 套餐起售停售
     * @param status
     * @param id
     * @return
     */
    @PostMapping("/status/{status}")
    @ApiOperation("起售停售")
    @CacheEvict(cacheNames = "setMealCache",allEntries = true)
    public Result startOrStop(@PathVariable Integer status,Long id){
        setMealService.startOrStop(status,id);
        return Result.success();
    }
}
