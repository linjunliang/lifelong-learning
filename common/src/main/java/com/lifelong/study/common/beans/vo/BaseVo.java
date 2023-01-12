package com.lifelong.study.common.beans.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 基类Vo
 *
 * @author lin
 * @date 2022/4/10
 */
@Data
public class BaseVo implements Serializable {

    private static final long serialVersionUID = 2398440123244581801L;

    private Integer id;

    private String mess;

    private Date createTime;

}
