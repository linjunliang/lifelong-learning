package com.lin.lifelong.learning.common.beans.vo;

import lombok.Data;

import java.util.Date;

/**
 * 基类Vo
 * @author lin
 * @date 2022/4/10
 */
@Data
public class BaseVo {

    private Integer id;

    private String mess;

    private Date createTime;

}
