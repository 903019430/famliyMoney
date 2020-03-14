package com.fm.famliymoney.memo.service.impl;

import com.fm.famliymoney.memo.entity.Memo;
import com.fm.famliymoney.memo.mapper.MemoMapper;
import com.fm.famliymoney.memo.service.IMemoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 备忘录表 服务实现类
 * </p>
 *
 * @author lls
 * @since 2020-03-13
 */
@Service
public class MemoServiceImpl extends ServiceImpl<MemoMapper, Memo> implements IMemoService {

}
