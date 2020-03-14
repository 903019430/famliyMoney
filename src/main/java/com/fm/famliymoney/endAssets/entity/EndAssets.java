package com.fm.famliymoney.endAssets.entity;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 月末资产情况表
 * </p>
 *
 * @author lls
 * @since 2020-03-13
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class EndAssets implements Serializable {

    private static final long serialVersionUID=1L;
    private String id;
    /**
     * 用户id
     */
    private String userid;

    /**
     * 收入支出金额
     */
    private Double siAmount;

    /**
     * 年份
     */
    private String year;

    /**
     * 月份
     */
    private String month;

    /**
     * 备注
     */
    private String remark;


}
