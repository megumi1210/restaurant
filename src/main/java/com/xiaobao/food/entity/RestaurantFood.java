package com.xiaobao.food.entity;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * restaurant_food
 * @author
 */
@Data
@ApiModel
public class RestaurantFood implements Serializable {
    /**
     * 自增ID
     */
    @ApiModelProperty(value = "食物id",required = false)
    private Long id;

    /**
     * 餐厅id
     */
    @ApiModelProperty(value = "餐厅id",required = false)
    private Long restaurantId;

    /**
     * 菜品名称
     */
    @ApiModelProperty(value = "菜品名称",required = false)
    private String name;

    /**
     * 菜品说明
     */
    @ApiModelProperty(value = "菜品说明",required = false)
    private String description;

    /**
     * 剩余份数
     */
    @ApiModelProperty(value = "剩余份数",required = false)
    private Integer count;

    /**
     * 菜品状态，0：已上线，1：已下线......
     */
    @ApiModelProperty(value = "餐厅状态，0： 已营业， 1： 已停业",required = false)
    private Byte status;

    /**
     * 创建时间
     */
    @JsonIgnore
    private Date createTime;

    /**
     * 修改时间
     */
    @JsonIgnore
    private Date updateTime;

    private static final long serialVersionUID = 1L;
}
