package com.fm.famliymoney;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//@MapperScan("com.fm.famliymoney.*.dao")
@SpringBootApplication
public class FamliymoneyApplication {


    public static void main(String[] args) {
        SpringApplication.run(FamliymoneyApplication.class, args);
    }

}
