package com.xiaobao.food.controller;


import com.xiaobao.food.entity.DefaultResIds;
import com.xiaobao.food.entity.Order;
import com.xiaobao.food.entity.Restaurant;
import com.xiaobao.food.entity.RestaurantFood;
import com.xiaobao.food.service.RestaurantService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



@Api(value="餐厅控制器", tags={"餐厅接口"})
@RestController
@RequestMapping("/restaurant")
public class RestaurantController {

  @Resource RestaurantService restaurantService;

  @Resource
  DefaultResIds defaultResIds;


  @GetMapping("/list")
  @ApiOperation(value = "查询餐厅列表",notes = "不分页")
  public List<Restaurant> findAll() {


    return restaurantService.findAll();

  }

  @GetMapping
  @ApiOperation(value = "根据餐厅id查询餐厅的食物列表",notes = "不分页")
  public List<RestaurantFood> findFoodById( @RequestParam(value = "id") Integer id){
    return restaurantService.findFoodById(id);
  }

  @PostMapping
  @ApiOperation(value = "下单",notes = "随机返回是否支付成功，会抛出异常")
  public boolean  placeOrder(@RequestBody Order order) throws Exception {

    return restaurantService.placeOrder(order) ;

  }
}
