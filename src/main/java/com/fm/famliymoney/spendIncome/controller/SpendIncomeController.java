package com.fm.famliymoney.spendIncome.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fm.famliymoney.spendIncome.entity.SpendIncome;
import com.fm.famliymoney.spendIncome.service.ISpendIncomeService;
import com.fm.famliymoney.until.ResponseData;
import com.fm.famliymoney.until.ResponseDataUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 支出收入分类表 前端控制器
 * </p>
 *
 * @author lls
 * @since 2020-03-13
 */
@RestController
@RequestMapping("/spendIncome")
public class SpendIncomeController {
    @Autowired
    private ISpendIncomeService iSpendIncomeService;
    /**
     * 获取page数据
     * @return
     */
    @GetMapping("getlist")
    public ResponseData list(Integer size, Integer page){
        Page<SpendIncome> spendIncomePage = new Page<>();
        if(null == size || null == page){
            spendIncomePage.setSize(20);
            spendIncomePage.setPages(1);
        }else {
            spendIncomePage.setSize(size);
            spendIncomePage.setPages(page);
        }
        spendIncomePage=iSpendIncomeService.page(spendIncomePage,new QueryWrapper<SpendIncome>().lambda().eq(SpendIncome::getDeleteStatus,0));
        return ResponseDataUtil.buildSuccess(spendIncomePage);
    }

    /**
     * 根据id获取信息
     * @param id
     * @return
     */
    @GetMapping("getById")
    public ResponseData getById(String id){
        SpendIncome spendIncome = iSpendIncomeService.getById(id);
        if(StringUtils.isBlank(id) && null == spendIncome){
            return ResponseDataUtil.buildError();
        }else{
            return ResponseDataUtil.buildSuccess(spendIncome);
        }
    }

    /**
     * 保存或修改
     * @return
     */
    @PostMapping("updateSave")
    public ResponseData updateSave(@RequestBody SpendIncome spendIncome){
        boolean row = iSpendIncomeService.saveOrUpdate(spendIncome,new UpdateWrapper<SpendIncome>().lambda().eq(SpendIncome::getDeleteStatus,0));
        if(row){
            return ResponseDataUtil.buildSuccess();
        }else{
            return ResponseDataUtil.buildError();
        }
    }

    /**
     * 删除数据
     * @param spendIncome
     * @return
     */
    @PostMapping("deleteById")
    public ResponseData deleteById(@RequestBody SpendIncome spendIncome){
        Boolean row = iSpendIncomeService.update(spendIncome,new UpdateWrapper<SpendIncome>().lambda().eq(SpendIncome::getDeleteStatus,1));
        if(row){
            return ResponseDataUtil.buildSuccess();
        }else{
            return ResponseDataUtil.buildError();
        }
    }
}

