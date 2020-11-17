package com.xiaobao.food.dao;

import com.xiaobao.food.entity.RestaurantFood;

import java.util.List;

public interface RestaurantFoodMapper {
    int deleteByPrimaryKey(Long id);

    int insert(RestaurantFood record);

    int insertSelective(RestaurantFood record);

    RestaurantFood selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(RestaurantFood record);

    int updateByPrimaryKey(RestaurantFood record);


    List<RestaurantFood> findFoodByRestaurantId(Integer rid);
}
