package com.fm.famliymoney.endAssets.controller;


import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fm.famliymoney.endAssets.entity.EndAssets;
import com.fm.famliymoney.endAssets.service.IEndAssetsService;
import com.fm.famliymoney.until.ResponseData;
import com.fm.famliymoney.until.ResponseDataUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 月末资产情况表 前端控制器
 * </p>
 *
 * @author lls
 * @since 2020-03-13
 */
@RestController
@RequestMapping("/endAssets")
public class EndAssetsController {
    @Autowired
    private IEndAssetsService iEndAssetsService;
    /**
     * 获取page数据
     * @return
     */
    @GetMapping("getlist")
    public ResponseData list(Integer size, Integer page){
        Page<EndAssets> endAssetsPage = new Page<>();
        if(null == size || null == page){
            endAssetsPage.setSize(20);
            endAssetsPage.setPages(1);
        }else {
            endAssetsPage.setSize(size);
            endAssetsPage.setPages(page);
        }
        endAssetsPage=iEndAssetsService.page(endAssetsPage,null);
        return ResponseDataUtil.buildSuccess(endAssetsPage);
    }

    /**
     * 根据id获取信息
     * @param id
     * @return
     */
    @GetMapping("getById")
    public ResponseData getById(String id){
        EndAssets endAssets = iEndAssetsService.getById(id);
        if(StringUtils.isBlank(id) && null == endAssets){
            return ResponseDataUtil.buildError();
        }else{
            return ResponseDataUtil.buildSuccess(endAssets);
        }
    }

    /**
     * 保存或修改
     * @return
     */
    @PostMapping("updateSave")
    public ResponseData updateSave(@RequestBody EndAssets endAssets){
        boolean row = iEndAssetsService.saveOrUpdate(endAssets,null);
        if(row){
            return ResponseDataUtil.buildSuccess();
        }else{
            return ResponseDataUtil.buildError();
        }
    }

    /**
     * 删除数据
     * @param endAssets
     * @return
     */
    @PostMapping("deleteById")
    public ResponseData deleteById(@RequestBody EndAssets endAssets){
        Boolean row = iEndAssetsService.update(endAssets,null);
        if(row){
            return ResponseDataUtil.buildSuccess();
        }else{
            return ResponseDataUtil.buildError();
        }
    }
}

