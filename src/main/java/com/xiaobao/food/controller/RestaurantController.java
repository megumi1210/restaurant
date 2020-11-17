package com.xiaobao.food.controller;

import com.xiaobao.food.dao.RestaurantFoodMapper;
import com.xiaobao.food.entity.Order;
import com.xiaobao.food.entity.Restaurant;
import com.xiaobao.food.entity.RestaurantFood;
import com.xiaobao.food.service.RestaurantService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;



@Api(value="餐厅控制器", tags={"餐厅接口"})
@RestController
@RequestMapping("/restaurant")
public class RestaurantController {

  @Resource RestaurantService restaurantService;






  @GetMapping("/list")
  @ApiOperation(value = "查询餐厅列表",notes = "不分页")
  public List<Restaurant> findAll() throws Exception {
    return restaurantService.findAll();
  }

  @GetMapping
  @ApiOperation(value = "根据餐厅id查询餐厅的食物列表",notes = "不分页")
  public List<RestaurantFood> findFoodById(@ApiParam(value = "餐厅id", required = true) @RequestParam("id") Integer id){
      return restaurantService.findFoodById(id);
  }

  @PostMapping
  public boolean  placeOrder(@RequestBody Order order) throws Exception {

    return restaurantService.placeOrder(order) ;

  }
}
