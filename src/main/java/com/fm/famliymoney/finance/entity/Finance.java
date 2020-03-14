package com.fm.famliymoney.finance.entity;

import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 财务信息表
 * </p>
 *
 * @author lls
 * @since 2020-03-13
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Finance implements Serializable {

    private static final long serialVersionUID=1L;
    private String id;
    /**
     * 用户id
     */
    private String userid;

    /**
     * 收支名称
     */
    private String payName;

    /**
     * 金额
     */
    private Double amount;

    /**
     * 家庭成员名称
     */
    private String familyName;

    /**
     * 家庭成员id
     */
    private String familyId;

    /**
     * 备注
     */
    private String remark;

    /**
     * 支出收入名称
     */
    private String siName;

    /**
     * 支出收入类型id
     */
    private String siTypeId;

    /**
     * 删除标识
     */
    private Integer deleteStatus;

    /**
     * 登记时间
     */
    private LocalDateTime createTime;

    /**
     * 登记年份
     */
    private String registerYear;


}
