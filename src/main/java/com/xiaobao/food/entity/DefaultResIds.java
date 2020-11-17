package com.xiaobao.food.entity;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DefaultResIds {

    @Value("${restaurant.ids}")
    String ids;

    public List<Long> getIds(){
        String[] tmp = ids.split(",");
        List<Long> idList = new ArrayList<>();

        for (String s : tmp) {
            idList.add(Long.parseLong(s));
        }

       return idList;
    }


}
