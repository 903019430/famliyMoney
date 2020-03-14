package com.fm.famliymoney.spendIncome.entity;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 支出收入分类表
 * </p>
 *
 * @author lls
 * @since 2020-03-13
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class SpendIncome implements Serializable {

    private static final long serialVersionUID=1L;
    private String id;
    /**
     * 名称
     */
    private String name;

    /**
     * 类型
     */
    private String type;

    /**
     * 删除标识
     */
    private Integer deleteStatus;

    /**
     * 照片类型
     */
    private String photoType;


}
