package com.xiaobao.food;


import com.xiaobao.food.entity.Order;
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
    public void findAll(){
    System.out.println( restaurantService.findAll());
    }


    @Test
    public void findFoodById(){
        System.out.println( restaurantService.findFoodById(2));
    }

    @Test
    public void placeOrder() throws Exception {
        Order order = new Order();
        order.setUserAccountId(1L);
        order.setRestaurantFoodId(2L);
        System.out.println( restaurantService.placeOrder(order));
    }

}
