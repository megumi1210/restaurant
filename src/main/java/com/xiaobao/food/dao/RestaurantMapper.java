package com.xiaobao.food.dao;

import com.xiaobao.food.entity.Restaurant;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RestaurantMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Restaurant record);

    int insertSelective(Restaurant record);

    Restaurant selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Restaurant record);

    int updateByPrimaryKey(Restaurant record);

    List<Restaurant> findAll();


    List<Restaurant> findDefaultRest(@Param("ids") List<Long> ids);


    List<Restaurant> findOtherRest(@Param("ids") List<Long> ids);
}
