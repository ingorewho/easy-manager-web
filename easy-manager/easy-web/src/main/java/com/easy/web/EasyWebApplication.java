package com.easy.web;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Author rzq
 * @Desc web启动类
 * @Date 2020-02-09
 **/
@SpringBootApplication()
@ComponentScan(basePackages={"com.easy"})
@MapperScan(basePackages = {"com.easy.infra.dao"})
public class EasyWebApplication {
    public static void main(String[] args) {
        SpringApplication.run(EasyWebApplication.class, args);
    }
}
