package com.w.zhujiemybatis.pojo;

import lombok.Data;

@Data
public class Account {
    private Integer id;
    private Integer uid;
    private Double money;
    //一对一关联用户
    private User user;
}
