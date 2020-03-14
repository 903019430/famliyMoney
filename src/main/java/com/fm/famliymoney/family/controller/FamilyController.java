package com.fm.famliymoney.family.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fm.famliymoney.family.entity.Family;
import com.fm.famliymoney.family.service.IFamilyService;
import com.fm.famliymoney.until.ResponseData;
import com.fm.famliymoney.until.ResponseDataUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 家庭成员信息表 前端控制器
 * </p>
 *
 * @author lls
 * @since 2020-03-13
 */
@RestController
@RequestMapping("/family")
public class FamilyController {
    @Autowired
    private IFamilyService iFamilyService;
    /**
     * 获取page数据
     * @return
     */
    @GetMapping("getlist")
    public ResponseData list(Integer size, Integer page){
        Page<Family> familyPage = new Page<>();
        if(null == size || null == page){
            familyPage.setSize(20);
            familyPage.setPages(1);
        }else {
            familyPage.setSize(size);
            familyPage.setPages(page);
        }
        familyPage=iFamilyService.page(familyPage,new QueryWrapper<Family>().lambda().eq(Family::getDeleteStatus,0));
        return ResponseDataUtil.buildSuccess(familyPage);
    }

    /**
     * 根据id获取信息
     * @param id
     * @return
     */
    @GetMapping("getById")
    public ResponseData getById(String id){
        Family family = iFamilyService.getById(id);
        if(StringUtils.isBlank(id) && null == family){
            return ResponseDataUtil.buildError();
        }else{
            return ResponseDataUtil.buildSuccess(family);
        }
    }

    /**
     * 保存或修改
     * @return
     */
    @PostMapping("updateSave")
    public ResponseData updateSave(Family family){
        boolean row = iFamilyService.saveOrUpdate(family,new UpdateWrapper<Family>().lambda().eq(Family::getDeleteStatus,0));
        if(row){
            return ResponseDataUtil.buildSuccess();
        }else{
            return ResponseDataUtil.buildError();
        }
    }

    /**
     * 删除数据
     * @param family
     * @return
     */
    @PostMapping("deleteById")
    public ResponseData deleteById(Family family){
        Boolean row = iFamilyService.update(family,new UpdateWrapper<Family>().lambda().eq(Family::getDeleteStatus,1));
        if(row){
            return ResponseDataUtil.buildSuccess();
        }else{
            return ResponseDataUtil.buildError();
        }
    }
}

