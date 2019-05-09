package com.w.zhujiemybatis.mapper;

import com.w.zhujiemybatis.pojo.Account;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface AccountMapper {
    /**
     * 查询所有账户，关联用户信息,一对一
     * one = @One(select = "com.w.zhujiemybatis.mapper.UserMapper.findById" UserMapper提供的根据id查找用户的方法
     * 最后一行中的column="uid"表示根据uid和用户关联查询，并且需要UserMapper提供一个根据id查询的方法
     * fetchType=FetchType.EAGER表示立即加载--------对一
     *                    .LAZY表示延迟加载---------对多
     */
    @Select("select * from account")
    @Results(id = "accountMap",value = {
         @Result(id =true,property = "id",column = "id"),
         @Result(property = "uid",column = "uid"),
            @Result(property = "money",column = "money"),
            @Result(property = "user",column = "uid",one = @One(select = "com.w.zhujiemybatis.mapper.UserMapper.findById",fetchType = FetchType.EAGER))

    })
    List<Account> findAll();


    /**
     * 根据用户id查询***注意：用户id！
     */
    @Select("select * from account where uid=#{uid}")
    List<Account> findAccountById(Integer uid);
}
