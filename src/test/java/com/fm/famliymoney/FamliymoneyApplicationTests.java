package com.fm.famliymoney;

import com.fm.famliymoney.users.mapper.UsersMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class FamliymoneyApplicationTests {
    @Resource
    private UsersMapper usersMapper;
    @Test
    void contextLoads() {
        System.out.println(usersMapper.selectList(null));

    }

}
