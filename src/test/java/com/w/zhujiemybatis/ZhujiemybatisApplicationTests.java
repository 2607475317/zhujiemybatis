package com.w.zhujiemybatis;

import com.w.zhujiemybatis.mapper.AccountMapper;
import com.w.zhujiemybatis.mapper.UserMapper;
import com.w.zhujiemybatis.pojo.Account;
import com.w.zhujiemybatis.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ZhujiemybatisApplicationTests {
      @Autowired
      private UserMapper userMapper;
      @Autowired
      private AccountMapper accountMapper;
    @Test
    public void contextLoads() {
        User byId = userMapper.findById(46);
        System.out.println(byId);

    }
    @Test
    public void test1(){
        List<Account> all = accountMapper.findAll();
        for (Account a:all){
            System.out.println(a);
        }
    }
    @Test
    public  void test2(){
        List<User> all = userMapper.findAll();
        for (User a:all){
            System.out.println(a);
        }
    }


}
