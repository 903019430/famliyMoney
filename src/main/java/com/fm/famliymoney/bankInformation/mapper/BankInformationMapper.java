package com.fm.famliymoney.bankInformation.mapper;

import com.fm.famliymoney.bankInformation.entity.BankInformation;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 银行往来信息表 Mapper 接口
 * </p>
 *
 * @author lls
 * @since 2020-03-13
 */
@Mapper
public interface BankInformationMapper extends BaseMapper<BankInformation> {

}
