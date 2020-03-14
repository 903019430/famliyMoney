package com.fm.famliymoney.family.entity;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 家庭成员信息表
 * </p>
 *
 * @author lls
 * @since 2020-03-13
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Family implements Serializable {

    private static final long serialVersionUID=1L;
    private String id;
    /**
     * 用户id
     */
    private String userid;

    /**
     * 姓名
     */
    private String name;

    /**
     * 工作
     */
    private String job;

    /**
     * 收支
     */
    private Integer budget;

    /**
     * 成员标识
     */
    private String memberStatus;

    /**
     * 删除标识
     */
    private Integer deleteStatus;

    /**
     * 创建标识
     */
    private Integer createStatus;

    /**
     * 消费额度
     */
    private Double moneyLimit;


}
