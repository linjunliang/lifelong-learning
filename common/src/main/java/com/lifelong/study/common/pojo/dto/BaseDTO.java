package com.lifelong.study.common.pojo.dto;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * BaseDTO
 *
 * @author: lin
 * @date: 2023/3/4
 */
@Data
public class BaseDTO implements Serializable {

    private static final long serialVersionUID = 8179101558200787038L;

    private Integer id;

    private LocalDateTime createTime;

    private String createUser;

    private LocalDateTime updateTime;

    private String updateUser;

    private Integer isDeleted;

}
