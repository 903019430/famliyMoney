package com.fm.famliymoney.admin.service.impl;

import com.fm.famliymoney.admin.entity.Admin;
import com.fm.famliymoney.admin.mapper.AdminMapper;
import com.fm.famliymoney.admin.service.IAdminService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 * 管理员表 服务实现类
 * </p>
 *
 * @author lls
 * @since 2020-03-13
 */
@Service
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin> implements IAdminService {

}
