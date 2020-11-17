package com.xiaobao.food.entity;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * user_account
 * @author
 */
@Data
public class UserAccount implements Serializable {
    /**
     * 自增ID
     */
    private Long id;

    /**
     * 年龄
     */
    private Long age;

    /**
     * 名字
     */
    private String name;

    /**
     * 手机号
     */
    private String phoneNumber;

    /**
     * 地址
     */
    private String address;

    /**
     * 用户状态，0：已创建，1：已下单......
     */
    private Byte status;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date updateTime;

    private static final long serialVersionUID = 1L;
}
