package com.fm.famliymoney.plan.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fm.famliymoney.plan.entity.Plan;
import com.fm.famliymoney.plan.service.IPlanService;
import com.fm.famliymoney.until.ResponseData;
import com.fm.famliymoney.until.ResponseDataUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 计划表 前端控制器
 * </p>
 *
 * @author lls
 * @since 2020-03-13
 */
@RestController
@RequestMapping("/plan")
public class PlanController {
    @Autowired
    private IPlanService iPlanService;
    /**
     * 获取page数据
     * @return
     */
    @GetMapping("getlist")
    public ResponseData list(Integer size, Integer page){
        Page<Plan> planPage = new Page<>();
        if(null == size || null == page){
            planPage.setSize(20);
            planPage.setPages(1);
        }else {
            planPage.setSize(size);
            planPage.setPages(page);
        }
        planPage=iPlanService.page(planPage,new QueryWrapper<Plan>().lambda().eq(Plan::getDeleteStatus,0));
        return ResponseDataUtil.buildSuccess(planPage);
    }

    /**
     * 根据id获取信息
     * @param id
     * @return
     */
    @GetMapping("getById")
    public ResponseData getById(String id){
        Plan plan = iPlanService.getById(id);
        if(StringUtils.isBlank(id) && null == plan){
            return ResponseDataUtil.buildError();
        }else{
            return ResponseDataUtil.buildSuccess(plan);
        }
    }

    /**
     * 保存或修改
     * @return
     */
    @PostMapping("updateSave")
    public ResponseData updateSave(Plan plan){
        boolean row = iPlanService.saveOrUpdate(plan,new UpdateWrapper<Plan>().lambda().eq(Plan::getDeleteStatus,0));
        if(row){
            return ResponseDataUtil.buildSuccess();
        }else{
            return ResponseDataUtil.buildError();
        }
    }

    /**
     * 删除数据
     * @param plan
     * @return
     */
    @PostMapping("deleteById")
    public ResponseData deleteById(Plan plan){
        Boolean row = iPlanService.update(plan,new UpdateWrapper<Plan>().lambda().eq(Plan::getDeleteStatus,1));
        if(row){
            return ResponseDataUtil.buildSuccess();
        }else{
            return ResponseDataUtil.buildError();
        }
    }
}

