package com.fm.famliymoney.spendIncomeUser.entity;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 支出收入用户管理表
 * </p>
 *
 * @author lls
 * @since 2020-03-13
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class SpendIncomeUser implements Serializable {

    private static final long serialVersionUID=1L;
    private String id;
    /**
     * 用户id
     */
    private String userid;

    /**
     * 支出收入类型id
     */
    private String siTypeId;

    /**
     * 支出收入名称
     */
    private String siName;

    /**
     * 删除标识
     */
    private Integer deleteStatus;

    /**
     * 图片类型
     */
    private String photoType;


}
