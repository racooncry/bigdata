package com.shenfeng.yangxw.sparkstatics.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author yangxw
 * @Date 2020-12-17 下午2:39
 * @Description
 * @Version 1.0
 */
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class UserAgentInfo {
    /**
     * 浏览器名称
     */
    private String browserName;

    /**
     * 浏览器版本
     */
    private String browserVersion;

    /**
     * 操作系统名称
     */
    private String osName;

    /**
     * 操作系统版本号
     */
    private String osVersion;
}
