package com.xiaobao.food;


import com.xiaobao.food.service.RestaurantService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RestaurantServiceTest {

    @Autowired
    RestaurantService restaurantService;

    @Test
    public void test1(){
    System.out.println( (int )(Math.random() + 0.5));
    }

}
