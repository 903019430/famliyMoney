package com.fm.famliymoney.spendIncomeUser.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fm.famliymoney.spendIncomeUser.entity.SpendIncomeUser;
import com.fm.famliymoney.spendIncomeUser.service.ISpendIncomeUserService;
import com.fm.famliymoney.until.ResponseData;
import com.fm.famliymoney.until.ResponseDataUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 支出收入用户管理表 前端控制器
 * </p>
 *
 * @author lls
 * @since 2020-03-13
 */
@RestController
@RequestMapping("/spendIncomeUser")
public class SpendIncomeUserController {
    @Autowired
    private ISpendIncomeUserService iSpendIncomeUserService;
    /**
     * 获取page数据
     * @return
     */
    @GetMapping("getlist")
    public ResponseData list(Integer size, Integer page){
        Page<SpendIncomeUser> spendIncomeUserPage = new Page<>();
        if(null == size || null == page){
            spendIncomeUserPage.setSize(20);
            spendIncomeUserPage.setPages(1);
        }else {
            spendIncomeUserPage.setSize(size);
            spendIncomeUserPage.setPages(page);
        }
        spendIncomeUserPage=iSpendIncomeUserService.page(spendIncomeUserPage,new QueryWrapper<SpendIncomeUser>().lambda().eq(SpendIncomeUser::getDeleteStatus,0));
        return ResponseDataUtil.buildSuccess(spendIncomeUserPage);
    }

    /**
     * 根据id获取信息
     * @param id
     * @return
     */
    @GetMapping("getById")
    public ResponseData getById(String id){
        SpendIncomeUser spendIncomeUser = iSpendIncomeUserService.getById(id);
        if(StringUtils.isBlank(id) && null == spendIncomeUser){
            return ResponseDataUtil.buildError();
        }else{
            return ResponseDataUtil.buildSuccess(spendIncomeUser);
        }
    }

    /**
     * 保存或修改
     * @return
     */
    @PostMapping("updateSave")
    public ResponseData updateSave(@RequestBody SpendIncomeUser spendIncomeUser){
        boolean row = iSpendIncomeUserService.saveOrUpdate(spendIncomeUser,new UpdateWrapper<SpendIncomeUser>().lambda().eq(SpendIncomeUser::getDeleteStatus,0));
        if(row){
            return ResponseDataUtil.buildSuccess();
        }else{
            return ResponseDataUtil.buildError();
        }
    }

    /**
     * 删除数据
     * @param spendIncomeUser
     * @return
     */
    @PostMapping("deleteById")
    public ResponseData deleteById(@RequestBody SpendIncomeUser spendIncomeUser){
        Boolean row = iSpendIncomeUserService.update(spendIncomeUser,new UpdateWrapper<SpendIncomeUser>().lambda().eq(SpendIncomeUser::getDeleteStatus,1));
        if(row){
            return ResponseDataUtil.buildSuccess();
        }else{
            return ResponseDataUtil.buildError();
        }
    }
}

