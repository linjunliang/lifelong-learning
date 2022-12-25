package com.lifelong.study.provider.api.beans.vo;

import com.lifelong.study.common.api.beans.vo.BaseVo;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 任务提供者VO
 *
 * @author: lin
 * @date: 2022/12/25
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class ProviderApiVo extends BaseVo {

    private String providerName;

}
