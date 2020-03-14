package com.fm.famliymoney.moneyInfo.entity;

import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 理财知识信息表
 * </p>
 *
 * @author lls
 * @since 2020-03-13
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class MoneyInfo implements Serializable {

    private static final long serialVersionUID=1L;
    private String id;
    /**
     * 创建时间
     */
    private LocalDateTime createDate;

    /**
     * 创建人id
     */
    private String createId;

    /**
     * 正文
     */
    private String mainBody;

    /**
     * 标题
     */
    private String title;

    /**
     * 备注
     */
    private String remark;

    /**
     * 删除标识
     */
    private Integer deleteStatus;

    /**
     * 最新标识
     */
    private Integer newStatus;

    /**
     * 投放标识
     */
    private Integer putStatus;

    /**
     * 置顶标识
     */
    private Integer upStatus;


}
