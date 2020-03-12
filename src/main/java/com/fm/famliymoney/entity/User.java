package com.fm.famliymoney.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class User extends Model<User> {
    @TableId
    private String openid;
    private String username;
    private String studentid;
    private String headimg;
    private String tel;
    private String address;
}
