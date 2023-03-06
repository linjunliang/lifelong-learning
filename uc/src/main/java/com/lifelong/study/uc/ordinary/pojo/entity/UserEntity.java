package com.lifelong.study.uc.ordinary.pojo.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.lifelong.study.common.pojo.entity.BaseEntity;
import lombok.*;

/**
 * 一般用户
 *
 * @author: lin
 * @date: 2023/3/4
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TableName("uc_user")
public class UserEntity extends BaseEntity {

    @TableField
    private String username;

    @TableField
    private String pwd;
}
