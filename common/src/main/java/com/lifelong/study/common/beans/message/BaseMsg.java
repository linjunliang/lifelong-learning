package com.lifelong.study.common.beans.message;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * 消息
 *
 * @author: lin
 * @date: 2023/1/12
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BaseMsg implements Serializable {

    private static final long serialVersionUID = -3749475088390527056L;

    private Integer id;

    private String mess;

    private Date createTime;

}
