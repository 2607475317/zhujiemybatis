package com.w.zhujiemybatis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.w.zhujiemybatis.mapper")
@SpringBootApplication
public class ZhujiemybatisApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZhujiemybatisApplication.class, args);
    }

}
