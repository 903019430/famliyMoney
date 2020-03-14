package com.fm.famliymoney.sysIntroduce.entity;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 系统内部显示信息表
 * </p>
 *
 * @author lls
 * @since 2020-03-13
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class SysIntroduce implements Serializable {

    private static final long serialVersionUID=1L;
    private String id;
    /**
     * 信息1
     */
    private String info1;

    /**
     * 信息2
     */
    private String info2;

    /**
     * 信息3
     */
    private String info3;

    /**
     * 信息4
     */
    private String info4;

    /**
     * 信息5
     */
    private String info5;

    /**
     * 信息6
     */
    private String info6;


}
