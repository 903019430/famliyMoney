package com.fm.famliymoney.bank.service.impl;

import com.fm.famliymoney.bank.entity.Bank;
import com.fm.famliymoney.bank.mapper.BankMapper;
import com.fm.famliymoney.bank.service.IBankService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 银行信息表 服务实现类
 * </p>
 *
 * @author lls
 * @since 2020-03-13
 */
@Service
public class BankServiceImpl extends ServiceImpl<BankMapper, Bank> implements IBankService {

}
