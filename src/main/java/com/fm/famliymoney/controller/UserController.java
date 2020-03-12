package com.fm.famliymoney.controller;

import com.fm.famliymoney.entity.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class UserController {
    @GetMapping(value = "getUserList")
    private List<User> getUserList(){
        return null;
    }
}