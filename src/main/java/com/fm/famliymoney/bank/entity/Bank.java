package com.fm.famliymoney.bank.entity;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 银行信息表
 * </p>
 *
 * @author lls
 * @since 2020-03-13
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Bank implements Serializable {

    private static final long serialVersionUID=1L;
    private String id;
    /**
     * 银行号
     */
    private String bankNo;

    /**
     * 银行名
     */
    private String bankName;

    /**
     * 持卡人
     */
    private String cardholder;

    /**
     * 用户id
     */
    private String userid;

    /**
     * 删除标识
     */
    private Integer deleteStatus;


}
