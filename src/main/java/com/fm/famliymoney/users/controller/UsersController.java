package com.fm.famliymoney.users.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fm.famliymoney.until.ResponseData;
import com.fm.famliymoney.until.ResponseDataUtil;
import com.fm.famliymoney.users.entity.Users;
import com.fm.famliymoney.users.mapper.UsersMapper;
import com.fm.famliymoney.users.service.IUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

/**
 * <p>
 * 用户信息表 前端控制器
 * </p>
 *
 * @author lls
 * @since 2020-03-13
 */
@RestController
@RequestMapping("/users")
public class UsersController {
    @Autowired
    private IUsersService iUsersService;
    /**
     * 获取page数据
     * @return
     */
    @GetMapping("getlist")
    public ResponseData list(Integer size, Integer page, Map<String,Object> params){
        Page<Users> usersPage = new Page<Users>();
        if(null == size || null == page){
            usersPage.setSize(20);
            usersPage.setCurrent(1);
        }else {
            usersPage.setSize(size);
            usersPage.setCurrent(page);
        }
        usersPage=iUsersService.page(usersPage,new QueryWrapper<Users>().lambda().eq(Users::getDeleteStatus,0));
        return ResponseDataUtil.buildSuccess(usersPage);
    }

    /**
     * 根据id获取信息
     * @param id
     * @return
     */
    @GetMapping("getById")
    public ResponseData getById(String id){
        Users users = iUsersService.getById(id);
        if(null == users){
            users.setDeleteStatus(0);
        }
        return ResponseDataUtil.buildSuccess(users);
    }

    /**
     * 保存或修改
     * @return
     */
    @PostMapping("updateSave")
    public ResponseData updateSave(@RequestBody Users users){
        boolean row = iUsersService.saveOrUpdate(users,new UpdateWrapper<Users>().lambda().eq(Users::getDeleteStatus,0));
        if(row){
            return ResponseDataUtil.buildSuccess();
        }else{
            return ResponseDataUtil.buildError();
        }
    }

    /**
     * 删除数据
     * @param users
     * @return
     */
    @PostMapping("deleteById")
    public ResponseData deleteById(@RequestBody Users users){
        Boolean row = iUsersService.update(users,new UpdateWrapper<Users>().lambda().eq(Users::getId,users.getId()).set(Users::getDeleteStatus,1));
        if(row){
            return ResponseDataUtil.buildSuccess();
        }else{
            return ResponseDataUtil.buildError();
        }
    }
}

