package com.lifelong.study.common.pojo.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * BaseEntity
 *
 * @author: lin
 * @date: 2023/3/4
 */
@Data
public class BaseEntity {

    @TableField
    private Integer id;

    @TableField
    private LocalDateTime createTime;

    @TableField
    private String creator;

    @TableField
    private LocalDateTime updateTime;

    @TableField
    private String updater;
}
