package com.fm.famliymoney.users.mapper;

import com.fm.famliymoney.users.entity.Users;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

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
    @Select("SELECT count(*) as num,DATE_FORMAT(create_date,'%Y-%m-%d') as date from money_info where DATE_SUB(CURDATE(), INTERVAL 7 DAY)<= date(create_date) GROUP BY DATE_FORMAT(create_date,'%Y-%m-%d')")
    List<Map<String, Object>> userWeekEcharts();
    @Select("SELECT count(*) as num,DATE_FORMAT(create_date,'%Y-%m-%d') as date from money_info where DATE_SUB(CURDATE(), INTERVAL 30 DAY)<= date(create_date) GROUP BY DATE_FORMAT(create_date,'%Y-%m-%d')")
    List<Map<String, Object>> userMonthEcharts();
    @Select("SELECT count(*) as num,DATE_FORMAT(create_date,'%Y-%m-%d') as date from money_info where DATE_SUB(CURDATE(), INTERVAL 365 DAY)<= date(create_date) GROUP BY DATE_FORMAT(create_date,'%Y-%m-%d')")
    List<Map<String, Object>> userYearEcharts();
}
