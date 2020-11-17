package com.xiaobao.food.entity;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * restaurant
 * @author
 */
@Data
@ApiModel
@JsonIgnoreProperties(ignoreUnknown = true)
public class Restaurant implements Serializable {
    /**
     * 自增ID
     */
    @ApiModelProperty(value = "餐厅的id",required = false)
    private Long id;

    /**
     * 餐厅名称
     */
    @ApiModelProperty(value = "餐厅名称",required = false)
    private String name;

    /**
     * 地址
     */
    @ApiModelProperty(value = "地址",required = false)
    private String address;

    /**
     * 餐厅状态，0：已营业，1：已停业......
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
