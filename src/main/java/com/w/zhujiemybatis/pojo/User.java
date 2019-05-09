package com.w.zhujiemybatis.pojo;

import lombok.Data;

import java.util.List;


@Data
public class User {
    private Integer id;
    private String username;
    private String address;
    private String sex;
    private String birthday;
    //一对多，关联账户
    private List<Account> accounts;
}
