package com.xiaobao.food.dao;

import com.xiaobao.food.entity.Order;

public interface OrderMapper {


    int insert(Order record);

    int insertSelective(Order record);


}
