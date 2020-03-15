package com.fm.famliymoney.users.service.impl;

import com.fm.famliymoney.users.entity.Users;
import com.fm.famliymoney.users.mapper.UsersMapper;
import com.fm.famliymoney.users.service.IUsersService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 * 用户信息表 服务实现类
 * </p>
 *
 * @author lls
 * @since 2020-03-13
 */
@Service
public class UsersServiceImpl extends ServiceImpl<UsersMapper, Users> implements IUsersService {
}
