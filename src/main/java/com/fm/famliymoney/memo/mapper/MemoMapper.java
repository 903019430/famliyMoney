package com.fm.famliymoney.memo.mapper;

import com.fm.famliymoney.memo.entity.Memo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 备忘录表 Mapper 接口
 * </p>
 *
 * @author lls
 * @since 2020-03-13
 */
@Mapper
public interface MemoMapper extends BaseMapper<Memo> {

}
