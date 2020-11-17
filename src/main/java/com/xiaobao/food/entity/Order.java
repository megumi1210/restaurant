package com.xiaobao.food.entity;

import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * order
 * @author
 */
@Data
@ApiModel
public class Order implements Serializable {
    /**
     * 自增ID
     */
    @ApiModelProperty(value = "订单的id",required = false)
    private Long id;

    /**
     * 餐厅菜品id
     */
    @ApiModelProperty(value = "食物的id",required = true)
    private Long restaurantFoodId;

    /**
     * 用户id
     */
    @ApiModelProperty(value = "用户的id",required = true)
    private Long userAccountId;

    /**
     * 订单状态，0：未支付，1：已支付
     */
    @ApiModelProperty(value = "支付状态",required = false)
    private Byte status;

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间",required = false)
    private Date createTime;

    /**
     * 修改时间
     */
    @ApiModelProperty(value = "修改时间",required = false)
    private Date updateTime;

    private static final long serialVersionUID = 1L;
}
