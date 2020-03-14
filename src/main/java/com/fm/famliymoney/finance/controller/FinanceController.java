package com.fm.famliymoney.finance.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fm.famliymoney.finance.entity.Finance;
import com.fm.famliymoney.finance.service.IFinanceService;
import com.fm.famliymoney.until.ResponseData;
import com.fm.famliymoney.until.ResponseDataUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 财务信息表 前端控制器
 * </p>
 *
 * @author lls
 * @since 2020-03-13
 */
@RestController
@RequestMapping("/finance")
public class FinanceController {
    @Autowired
    private IFinanceService iFinanceService;

    /**
     * 获取page数据
     * @return
     */
    @GetMapping("getlist")
    public ResponseData list(Integer size, Integer page){
        Page<Finance> financePage = new Page<>();
        if(null == size || null == page){
            financePage.setSize(20);
            financePage.setPages(1);
        }else {
            financePage.setSize(size);
            financePage.setPages(page);
        }
        financePage=iFinanceService.page(financePage,new QueryWrapper<Finance>().lambda().eq(Finance::getDeleteStatus,0));
        return ResponseDataUtil.buildSuccess(financePage);
    }

    /**
     * 根据id获取信息
     * @param id
     * @return
     */
    @GetMapping("getById")
    public ResponseData getById(String id){
        Finance finance = iFinanceService.getById(id);
        if(StringUtils.isBlank(id) && null == finance){
            return ResponseDataUtil.buildError();
        }else{
            return ResponseDataUtil.buildSuccess(finance);
        }
    }

    /**
     * 保存或修改
     * @return
     */
    @PostMapping("updateSave")
    public ResponseData updateSave(Finance finance){
        boolean row = iFinanceService.saveOrUpdate(finance,new UpdateWrapper<Finance>().lambda().eq(Finance::getDeleteStatus,0));
        if(row){
            return ResponseDataUtil.buildSuccess();
        }else{
            return ResponseDataUtil.buildError();
        }
    }

    /**
     * 删除数据
     * @param finance
     * @return
     */
    @PostMapping("deleteById")
    public ResponseData deleteById(Finance finance){
        Boolean row = iFinanceService.update(finance,new UpdateWrapper<Finance>().lambda().eq(Finance::getDeleteStatus,1));
        if(row){
            return ResponseDataUtil.buildSuccess();
        }else{
            return ResponseDataUtil.buildError();
        }
    }
}

