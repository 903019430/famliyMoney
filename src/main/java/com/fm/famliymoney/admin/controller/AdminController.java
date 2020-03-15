package com.fm.famliymoney.admin.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.fm.famliymoney.admin.entity.Admin;
import com.fm.famliymoney.admin.service.IAdminService;
import com.fm.famliymoney.admin.service.impl.AdminServiceImpl;
import com.fm.famliymoney.until.ResponseData;
import com.fm.famliymoney.until.ResponseDataUtil;
import com.fm.famliymoney.until.ResultEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * <p>
 * 管理员表 前端控制器
 * </p>
 *
 * @author lls
 * @since 2020-03-13
 */
@RestController
@RequestMapping("/admin")
public class AdminController {
    @Resource
    private AdminServiceImpl adminService;
    @Resource
    private IAdminService iAdminService;
     @PostMapping("login")
     public ResponseData login(HttpServletRequest request , String username, String password){
         Admin admin = new Admin();
            try {
                admin = adminService.getOne(new QueryWrapper<Admin>().lambda().eq(Admin::getUsername,username).eq(Admin::getPassword,password));
            }catch (Exception e){
                e.printStackTrace();
                return ResponseDataUtil.buildError(ResultEnum.SYSTEM_ERROR);
            }
            if(admin != null){
                request.getSession().setAttribute("username",admin.getUsername());
                request.getSession().setMaxInactiveInterval(-1);
                admin.setPassword(null);
                return ResponseDataUtil.buildSuccess(admin);
            }
         return ResponseDataUtil.buildError(false,"账号密码有误！请重新输入");
        }

        @GetMapping("getlist")
        public ResponseData getlist(){
            return ResponseDataUtil.buildSuccess(ResultEnum.SUCCESS);
        }

        @GetMapping("logout")
        public ResponseData logout(HttpServletRequest request){
         request.getSession().removeAttribute("username");
         return ResponseDataUtil.buildSuccess();
        }

        @PostMapping("updatePWD")
        public ResponseData updataPWD(String id,String password,String newpassword){
         Admin admin =  iAdminService.getById(id);
         if(null != admin){
             if(admin.getPassword().equals(password)){
                 iAdminService.update(new UpdateWrapper<Admin>().lambda().eq(Admin::getId,id).set(Admin::getPassword,newpassword));
             }else{
                 return ResponseDataUtil.buildError(false,"您的密码有误，请重新输入");
             }
         }
         return ResponseDataUtil.buildSuccess();
        }
}

