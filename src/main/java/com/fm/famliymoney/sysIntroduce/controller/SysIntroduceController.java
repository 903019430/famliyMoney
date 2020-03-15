package com.fm.famliymoney.sysIntroduce.controller;


import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fm.famliymoney.sysIntroduce.entity.SysIntroduce;
import com.fm.famliymoney.sysIntroduce.service.ISysIntroduceService;
import com.fm.famliymoney.until.ResponseData;
import com.fm.famliymoney.until.ResponseDataUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 系统内部显示信息表 前端控制器
 * </p>
 *
 * @author lls
 * @since 2020-03-13
 */
@RestController
@RequestMapping("/sysIntroduce")
public class SysIntroduceController {
    @Autowired
    private ISysIntroduceService iSysIntroduceService;
    /**
     * 获取page数据
     * @return
     */
    @GetMapping("getlist")
    public ResponseData list(Integer size, Integer page){
        Page<SysIntroduce> sysIntroducePage = new Page<>();
        if(null == size || null == page){
            sysIntroducePage.setSize(20);
            sysIntroducePage.setPages(1);
        }else {
            sysIntroducePage.setSize(size);
            sysIntroducePage.setPages(page);
        }
        sysIntroducePage=iSysIntroduceService.page(sysIntroducePage);
        return ResponseDataUtil.buildSuccess(sysIntroducePage);
    }

    /**
     * 根据id获取信息
     * @param id
     * @return
     */
    @GetMapping("getById")
    public ResponseData getById(String id){
        SysIntroduce sysIntroduce = iSysIntroduceService.getById(id);
        if(StringUtils.isBlank(id) && null == sysIntroduce){
            return ResponseDataUtil.buildError();
        }else{
            return ResponseDataUtil.buildSuccess(sysIntroduce);
        }
    }

    /**
     * 保存或修改
     * @return
     */
    @PostMapping("updateSave")
    public ResponseData updateSave(@RequestBody SysIntroduce sysIntroduce){
        boolean row = iSysIntroduceService.saveOrUpdate(sysIntroduce);
        if(row){
            return ResponseDataUtil.buildSuccess();
        }else{
            return ResponseDataUtil.buildError();
        }
    }

    /**
     * 删除数据
     * @param sysIntroduce
     * @return
     */
    @PostMapping("deleteById")
    public ResponseData deleteById(@RequestBody SysIntroduce sysIntroduce){
        Boolean row = iSysIntroduceService.update(sysIntroduce,null);
        if(row){
            return ResponseDataUtil.buildSuccess();
        }else{
            return ResponseDataUtil.buildError();
        }
    }
}

