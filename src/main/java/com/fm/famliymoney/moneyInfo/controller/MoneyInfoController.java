package com.fm.famliymoney.moneyInfo.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fm.famliymoney.memo.entity.Memo;
import com.fm.famliymoney.memo.service.IMemoService;
import com.fm.famliymoney.moneyInfo.entity.MoneyInfo;
import com.fm.famliymoney.moneyInfo.service.IMoneyInfoService;
import com.fm.famliymoney.until.ResponseData;
import com.fm.famliymoney.until.ResponseDataUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 理财知识信息表 前端控制器
 * </p>
 *
 * @author lls
 * @since 2020-03-13
 */
@RestController
@RequestMapping("/moneyInfo")
public class MoneyInfoController {
    @Autowired
    private IMoneyInfoService iMoneyInfoService;
    /**
     * 获取page数据
     * @return
     */
    @GetMapping("getlist")
    public ResponseData list(Integer size, Integer page){
        Page<MoneyInfo> moneyInfoPage = new Page<>();
        if(null == size || null == page){
            moneyInfoPage.setSize(20);
            moneyInfoPage.setPages(1);
        }else {
            moneyInfoPage.setSize(size);
            moneyInfoPage.setPages(page);
        }
        moneyInfoPage=iMoneyInfoService.page(moneyInfoPage,new QueryWrapper<MoneyInfo>().lambda().eq(MoneyInfo::getDeleteStatus,0));
        return ResponseDataUtil.buildSuccess(moneyInfoPage);
    }

    /**
     * 根据id获取信息
     * @param id
     * @return
     */
    @GetMapping("getById")
    public ResponseData getById(String id){
        MoneyInfo moneyInfo = iMoneyInfoService.getById(id);
        if(StringUtils.isBlank(id) && null == moneyInfo){
            return ResponseDataUtil.buildError();
        }else{
            return ResponseDataUtil.buildSuccess(moneyInfo);
        }
    }

    /**
     * 保存或修改
     * @return
     */
    @PostMapping("updateSave")
    public ResponseData updateSave(@RequestBody MoneyInfo moneyInfo){
        boolean row = iMoneyInfoService.saveOrUpdate(moneyInfo,new UpdateWrapper<MoneyInfo>().lambda().eq(MoneyInfo::getDeleteStatus,0));
        if(row){
            return ResponseDataUtil.buildSuccess();
        }else{
            return ResponseDataUtil.buildError();
        }
    }

    /**
     * 删除数据
     * @param moneyInfo
     * @return
     */
    @PostMapping("deleteById")
    public ResponseData deleteById(@RequestBody MoneyInfo moneyInfo){
        Boolean row = iMoneyInfoService.update(moneyInfo,new UpdateWrapper<MoneyInfo>().lambda().eq(MoneyInfo::getDeleteStatus,1));
        if(row){
            return ResponseDataUtil.buildSuccess();
        }else{
            return ResponseDataUtil.buildError();
        }
    }
}

