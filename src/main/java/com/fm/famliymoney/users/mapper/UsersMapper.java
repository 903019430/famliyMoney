package com.fm.famliymoney.users.mapper;

import com.fm.famliymoney.users.entity.Users;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * <p>
 * 用户信息表 Mapper 接口
 * </p>
 *
 * @author lls
 * @since 2020-03-13
 */
@Mapper
public interface UsersMapper extends BaseMapper<Users> {

}
