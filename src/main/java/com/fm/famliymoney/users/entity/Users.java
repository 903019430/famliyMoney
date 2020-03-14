package com.fm.famliymoney.users.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 * 用户信息表
 * </p>
 *
 * @author lls
 * @since 2020-03-13
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Users implements Serializable {

    private static final long serialVersionUID=1L;
    private String id;
    /**
     * 微信标识1
     */
    private String wechatlogo1;

    /**
     * 微信标识2
     */
    private String wechatlogo2;

    /**
     * 微信标识3
     */
    private String wechatlogo3;

    /**
     * 微信标识4
     */
    private String wechatlogo4;

    /**
     * 删除标识
     */
    private Integer deleteStatus;


}
