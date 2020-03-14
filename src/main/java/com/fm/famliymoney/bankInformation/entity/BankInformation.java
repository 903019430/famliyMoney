package com.fm.famliymoney.bankInformation.entity;

import java.time.LocalDate;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 银行往来信息表
 * </p>
 *
 * @author lls
 * @since 2020-03-13
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class BankInformation implements Serializable {

    private static final long serialVersionUID=1L;
    private String id;
    /**
     * 银行账号
     */
    private String bankNo;

    /**
     * 交易日期
     */
    private LocalDate tradeDate;

    /**
     * 交易类型
     */
    private String tradeType;

    /**
     * 交易金额
     */
    private Double tradeMoney;

    /**
     * 备注
     */
    private String remark;

    /**
     * 删除标识
     */
    private Integer deleteStatus;

    /**
     * 银行id
     */
    private String bankId;

    /**
     * 用户id
     */
    private String userid;


}
