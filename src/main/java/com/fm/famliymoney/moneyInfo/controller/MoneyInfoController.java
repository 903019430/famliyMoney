package com.fm.famliymoney.moneyInfo.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fm.famliymoney.moneyInfo.entity.MoneyInfo;
import com.fm.famliymoney.moneyInfo.service.IMoneyInfoService;
import com.fm.famliymoney.until.ResponseData;
import com.fm.famliymoney.until.ResponseDataUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.Date;

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
    public ResponseData list(Integer size, Integer page,String title,String createDate){
        Page<MoneyInfo> moneyInfoPage = new Page<>();
        if(null == size || null == page){
            moneyInfoPage.setSize(20);
            moneyInfoPage.setPages(1);
        }else {
            moneyInfoPage.setSize(size);
            moneyInfoPage.setPages(page);
        }
        QueryWrapper<MoneyInfo> queryWrapper = new QueryWrapper<MoneyInfo>();
        queryWrapper.lambda().eq(MoneyInfo::getDeleteStatus,0).orderByDesc(MoneyInfo::getCreateDate);
        if(null!=title){
            queryWrapper.lambda().like(MoneyInfo::getTitle,title);
        }
        if(null != createDate){
            queryWrapper.lambda().like(MoneyInfo::getCreateDate,createDate);
        }
        moneyInfoPage=iMoneyInfoService.page(moneyInfoPage,queryWrapper);
        return ResponseDataUtil.buildSuccess(moneyInfoPage);
    }

    /**
     * 根据id获取信息
     * @param id
     * @return
     */
    @GetMapping("getById")
    public ResponseData getById(String id, HttpServletRequest request){
        MoneyInfo moneyInfo = iMoneyInfoService.getById(id);
        if(null == moneyInfo){
            String userid = (String) request.getSession().getAttribute("username");
            moneyInfo = new MoneyInfo();
            moneyInfo.setDeleteStatus(0);
            moneyInfo.setCreateId(userid);
        }
        return ResponseDataUtil.buildSuccess(moneyInfo);
    }

    /**
     * 保存或修改
     * @return
     */
    @PostMapping("updateSave")
    public ResponseData updateSave(@RequestBody MoneyInfo moneyInfo){
        if(null==moneyInfo.getId()){
            moneyInfo.setCreateDate(LocalDateTime.now());
        }
        boolean row = iMoneyInfoService.saveOrUpdate(moneyInfo);
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

