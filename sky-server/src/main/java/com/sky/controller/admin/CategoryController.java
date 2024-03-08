package com.sky.controller.admin;

import com.sky.dto.CategoryDTO;
import com.sky.dto.CategoryPageQueryDTO;
import com.sky.entity.Category;
import com.sky.result.PageResult;
import com.sky.result.Result;
import com.sky.service.CategoryService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author:zjj
 * @date:2024/3/8 9:10
 * @Description:
 */
@RestController
@Slf4j
@RequestMapping("/admin/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    /**
     * 新增分类
     * @param categoryDTO
     * @return
     */
    @PostMapping
    @ApiOperation("新增分类")
    public Result<String> save(@RequestBody CategoryDTO categoryDTO){
        categoryService.save(categoryDTO);
        return Result.success();
    }

    /**
     * 分页查询
     * @param categoryPageQueryDTO
     * @return
     */
    @GetMapping("/page")
    @ApiOperation("分页查询")
    public Result<PageResult> page(CategoryPageQueryDTO categoryPageQueryDTO){
        PageResult pageResult = categoryService.pageQuery(categoryPageQueryDTO);
        return Result.success(pageResult);
    }

    @DeleteMapping
    @ApiOperation("根据id删除分类")
    public Result<String> deleteById(Long id){
        categoryService.deleteById(id);
        return Result.success();
    }


    /**
     * 修改分类
     * @param categoryDTO
     * @return
     */
    @PutMapping
    @ApiOperation("修改分类")
    public Result<String> update(@RequestBody CategoryDTO categoryDTO){
        categoryService.update(categoryDTO);
        return Result.success();
    }

    /**
     * 根据类型查询分类 status为1：菜品分类
     *               status为2：套餐分类
     * @param type
     * @return
     */
    @GetMapping("/list")
    @ApiOperation("根据类型查询分类")
    public Result<List<Category>> list(Integer type){
        List<Category> categories =  categoryService.list(type);
        return Result.success(categories);
    }

    /**
     * 启用禁用分类
     * @param status
     * @param id
     * @return
     */
    @PostMapping("/status/{status}")
    @ApiOperation("启用禁用分类")
    public Result startOrStop(@PathVariable Integer status , Long id){
        categoryService.update(status,id);
        return Result.success();
    }


}
