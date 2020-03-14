package com.fm.famliymoney.bankInformation.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fm.famliymoney.bankInformation.entity.BankInformation;
import com.fm.famliymoney.bankInformation.service.IBankInformationService;
import com.fm.famliymoney.until.ResponseData;
import com.fm.famliymoney.until.ResponseDataUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 银行往来信息表 前端控制器
 * </p>
 *
 * @author lls
 * @since 2020-03-13
 */
@RestController
@RequestMapping("/bankInformation")
public class BankInformationController {
    @Autowired
    private IBankInformationService iBankInformationService;

    /**
     * 获取page数据
     * @return
     */
    @GetMapping("getlist")
    public ResponseData list(Integer size, Integer page){
        Page<BankInformation> bankInformationPage = new Page<>();
        if(null== size || null == page){
            bankInformationPage.setSize(20);
            bankInformationPage.setPages(1);
        }else {
            bankInformationPage.setSize(size);
            bankInformationPage.setPages(page);
        }
        bankInformationPage=iBankInformationService.page(bankInformationPage,new QueryWrapper<BankInformation>().lambda().eq(BankInformation::getDeleteStatus,0));
        return ResponseDataUtil.buildSuccess(bankInformationPage);
    }

    /**
     * 根据id获取信息
     * @param id
     * @return
     */
    @GetMapping("getById")
    public ResponseData getById(String id){
        BankInformation bankInformation = iBankInformationService.getById(id);
        if(StringUtils.isBlank(id) && null == bankInformation){
            return ResponseDataUtil.buildError();
        }else{
            return ResponseDataUtil.buildSuccess(bankInformation);
        }
    }

    /**
     * 保存或修改
     * @return
     */
    @PostMapping("updateSave")
    public ResponseData updateSave(BankInformation bankInformation){
        boolean row = iBankInformationService.saveOrUpdate(bankInformation,new UpdateWrapper<BankInformation>().lambda().eq(BankInformation::getDeleteStatus,0));
        if(row){
            return ResponseDataUtil.buildSuccess();
        }else{
            return ResponseDataUtil.buildError();
        }
    }

    /**
     * 删除数据
     * @param bankInformation
     * @return
     */
    @PostMapping("deleteById")
    public ResponseData deleteById(BankInformation bankInformation){
        Boolean row = iBankInformationService.update(bankInformation,new UpdateWrapper<BankInformation>().lambda().eq(BankInformation::getDeleteStatus,1));
        if(row){
            return ResponseDataUtil.buildSuccess();
        }else{
            return ResponseDataUtil.buildError();
        }
    }
}

