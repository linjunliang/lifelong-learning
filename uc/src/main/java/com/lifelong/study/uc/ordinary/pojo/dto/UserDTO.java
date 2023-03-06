package com.lifelong.study.uc.ordinary.pojo.dto;

import com.lifelong.study.common.pojo.dto.BaseDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 用户Dto
 *
 * @author: lin
 * @date: 2023/3/6
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class UserDTO extends BaseDTO {

    private static final long serialVersionUID = -1498882591707126576L;

    private String username;

    private String pwd;

}
