package com.w.zhujiemybatis.mapper;

import com.w.zhujiemybatis.pojo.User;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface UserMapper {
    /**
     * 查询所有，关联账户信息，一对多
     * @return
     * 最后一行的column表示根据id和账户表关联,并且需要AccountMapper提供一个根据用户Id查询的方法
     * fetchType = FetchType.LAZY 表示延迟加载，通常应用与一对多
     */
    @Select("select *from user")
    @Results( id = "userMap",value = {
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "username",column = "username"),
            @Result(property = "address",column = "address"),
            @Result(property = "sex",column = "sex"),
            @Result(property = "birthday",column = "birthday"),
            @Result(property = "accounts",column = "id",many = @Many(select = "com.w.zhujiemybatis.mapper.AccountMapper.findAccountById",fetchType = FetchType.LAZY))
    })
    List<User> findAll();



    /**
     * 根据id查询用户
     */
    @Select("select * from user where id=#{id}")
    User findById(Integer id);
}
