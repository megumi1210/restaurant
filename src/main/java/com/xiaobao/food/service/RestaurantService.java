package com.xiaobao.food.service;

import com.xiaobao.food.dao.OrderMapper;
import com.xiaobao.food.dao.RestaurantFoodMapper;
import com.xiaobao.food.dao.RestaurantMapper;
import com.xiaobao.food.entity.DefaultResIds;
import com.xiaobao.food.entity.Order;
import com.xiaobao.food.entity.Restaurant;
import com.xiaobao.food.entity.RestaurantFood;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class RestaurantService {

  @Resource RestaurantMapper restaurantMapper;

  @Resource RestaurantFoodMapper restaurantFoodMapper;

  @Resource
  OrderMapper orderMapper;

  @Resource
  DefaultResIds defaultResIds;

  public List<Restaurant> findAll() {

    List<Restaurant> defaultRest = restaurantMapper.findDefaultRest(defaultResIds.getIds());
    List<Restaurant> otherRest = restaurantMapper.findOtherRest(defaultResIds.getIds());

    defaultRest.addAll(otherRest);
    return defaultRest;
  }

  public List<RestaurantFood> findFoodById(Integer id) {
    return restaurantFoodMapper.findFoodByRestaurantId(id);
  }


  @Transactional(rollbackFor = Exception.class)
  public boolean placeOrder(Order order) throws Exception {

    Long foodId = order.getRestaurantFoodId();
    RestaurantFood food =restaurantFoodMapper.selectByPrimaryKey(foodId);
    if(food == null || food.getCount() == 0){
      return  false;
    }

    int  paySuccess = (int )(Math.random() + 0.5);
    order.setStatus((byte) paySuccess);
    boolean result =orderMapper.insertSelective(order) > 0;

    food.setCount(food.getCount()-1);
    restaurantFoodMapper.updateByPrimaryKey(food);

    if(paySuccess != 1){
      throw new Exception("支付失败");
    }


    return result;


  }
}
