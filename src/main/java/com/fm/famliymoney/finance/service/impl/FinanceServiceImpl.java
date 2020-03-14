package com.fm.famliymoney.finance.service.impl;

import com.fm.famliymoney.finance.entity.Finance;
import com.fm.famliymoney.finance.mapper.FinanceMapper;
import com.fm.famliymoney.finance.service.IFinanceService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 财务信息表 服务实现类
 * </p>
 *
 * @author lls
 * @since 2020-03-13
 */
@Service
public class FinanceServiceImpl extends ServiceImpl<FinanceMapper, Finance> implements IFinanceService {

}
