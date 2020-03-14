package com.fm.famliymoney.memo.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fm.famliymoney.memo.entity.Memo;
import com.fm.famliymoney.memo.service.IMemoService;
import com.fm.famliymoney.until.ResponseData;
import com.fm.famliymoney.until.ResponseDataUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 备忘录表 前端控制器
 * </p>
 *
 * @author lls
 * @since 2020-03-13
 */
@RestController
@RequestMapping("/memo")
public class MemoController {
    @Autowired
    private IMemoService iMemoService;
    /**
     * 获取page数据
     * @return
     */
    @GetMapping("getlist")
    public ResponseData list(Integer size, Integer page){
        Page<Memo> memoPage = new Page<>();
        if(null == size || null == page){
            memoPage.setSize(20);
            memoPage.setPages(1);
        }else {
            memoPage.setSize(size);
            memoPage.setPages(page);
        }
        memoPage=iMemoService.page(memoPage,new QueryWrapper<Memo>().lambda().eq(Memo::getDeleteStatus,0));
        return ResponseDataUtil.buildSuccess(memoPage);
    }

    /**
     * 根据id获取信息
     * @param id
     * @return
     */
    @GetMapping("getById")
    public ResponseData getById(String id){
        Memo memo = iMemoService.getById(id);
        if(StringUtils.isBlank(id) && null == memo){
            return ResponseDataUtil.buildError();
        }else{
            return ResponseDataUtil.buildSuccess(memo);
        }
    }

    /**
     * 保存或修改
     * @return
     */
    @PostMapping("updateSave")
    public ResponseData updateSave(Memo memo){
        boolean row = iMemoService.saveOrUpdate(memo,new UpdateWrapper<Memo>().lambda().eq(Memo::getDeleteStatus,0));
        if(row){
            return ResponseDataUtil.buildSuccess();
        }else{
            return ResponseDataUtil.buildError();
        }
    }

    /**
     * 删除数据
     * @param memo
     * @return
     */
    @PostMapping("deleteById")
    public ResponseData deleteById(Memo memo){
        Boolean row = iMemoService.update(memo,new UpdateWrapper<Memo>().lambda().eq(Memo::getDeleteStatus,1));
        if(row){
            return ResponseDataUtil.buildSuccess();
        }else{
            return ResponseDataUtil.buildError();
        }
    }
}

