package com.fm.famliymoney.plan.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 计划表
 * </p>
 *
 * @author lls
 * @since 2020-03-13
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Plan implements Serializable {

    private static final long serialVersionUID=1L;
    private String id;
    /**
     * 创建时间
     */
    private LocalDateTime createDate;

    /**
     * 更新时间
     */
    private LocalDateTime updateDate;

    /**
     * 主题
     */
    private String theme;

    /**
     * 正文
     */
    private String mainBody;

    /**
     * 开始时间
     */
    private LocalDate startTime;

    /**
     * 结束时间
     */
    private LocalDate endTime;

    /**
     * 花费
     */
    private Double cost;

    /**
     * 用途
     */
    private String purpose;

    /**
     * 用户id
     */
    private String userid;

    /**
     * 删除标识
     */
    private Integer deleteStatus;

    /**
     * 完成标识
     */
    private Integer completeStatus;


}
