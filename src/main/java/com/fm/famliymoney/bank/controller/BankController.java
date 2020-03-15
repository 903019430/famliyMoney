package com.fm.famliymoney.bank.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fm.famliymoney.bank.entity.Bank;
import com.fm.famliymoney.bank.service.IBankService;
import com.fm.famliymoney.until.ResponseData;
import com.fm.famliymoney.until.ResponseDataUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 银行信息表 前端控制器
 * </p>
 *
 * @author lls
 * @since 2020-03-13
 */
@RestController
@RequestMapping("/bank")
public class BankController {
    @Autowired
    private IBankService iBankService;

    /**
     * 获取page数据
     * @param size
     * @param page
     * @return
     */
    @GetMapping("getlist")
    public ResponseData list(Integer size,Integer page){
        Page<Bank> bankPage  = new Page<>();
        if(null == size || null == page){
            bankPage.setSize(20);
            bankPage.setPages(1);
        }else {
            bankPage.setPages(page);
            bankPage.setSize(size);
        }
        bankPage = iBankService.page(bankPage,new QueryWrapper<Bank>().lambda().eq(Bank::getDeleteStatus,0));
        return ResponseDataUtil.buildSuccess(bankPage);
    }

    /**
     * 根据id获取信息
     * @param id
     * @return
     */
    @GetMapping("getById")
    public ResponseData getById(String id){
        Bank bank = iBankService.getById(id);
        if(StringUtils.isBlank(id)){
            return ResponseDataUtil.buildError();
        }
        return ResponseDataUtil.buildSuccess(bank);
    }

    /**
     * 保存或修改
     * @param bank
     * @return
     */
    @PostMapping("updataSave")
    public ResponseData updataSave(@RequestBody Bank bank){
        Boolean row = iBankService.saveOrUpdate(bank,new UpdateWrapper<Bank>().lambda().eq(Bank::getDeleteStatus,0));
        if(row){
            return ResponseDataUtil.buildSuccess();
        }else{
            return ResponseDataUtil.buildError();
        }
    }
    /**
     * 删除数据
     * @param bank
     * @return
     */
    @PostMapping("deleteById")
    public ResponseData deleteById(@RequestBody Bank bank){
        Boolean row = iBankService.update(bank,new UpdateWrapper<Bank>().lambda().eq(Bank::getDeleteStatus,1));
        if(row){
            return ResponseDataUtil.buildSuccess();
        }else{
            return ResponseDataUtil.buildError();
        }
    }
}

