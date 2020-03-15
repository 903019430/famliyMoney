package com.fm.famliymoney.admin.config;

import com.fm.famliymoney.until.ResponseData;
import com.fm.famliymoney.until.ResponseDataUtil;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Aspect
@Component
public class LoginAspect {

    @Pointcut("execution(public * com.fm.famliymoney..*Controller..*(..))&&!execution(public * com.fm.famliymoney.admin.controller." +
            "AdminController.login(..))")
    public void OperaCheck(){}

    @Before("OperaCheck()")
    public ResponseData before(JoinPoint point){
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String username = (String) request.getSession().getAttribute("username");
        if(username == null){
            throw new RuntimeException("您没有权限进入，请登录!");
        }
        return ResponseDataUtil.buildSuccess();
    }
}
