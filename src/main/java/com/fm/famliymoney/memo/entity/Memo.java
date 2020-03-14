package com.fm.famliymoney.memo.entity;

import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 备忘录表
 * </p>
 *
 * @author lls
 * @since 2020-03-13
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Memo implements Serializable {

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
     * 用户id
     */
    private String userid;

    /**
     * 删除标识
     */
    private Integer deleteStatus;

    /**
     * 置顶标识
     */
    private Integer upStatus;


}
