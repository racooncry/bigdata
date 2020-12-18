package com.shenfeng.yangxw.sparkstatics.utils;

import com.shenfeng.yangxw.sparkstatics.domain.UserAgentInfo;
import cz.mallat.uasparser.OnlineUpdater;
import cz.mallat.uasparser.UASparser;
import org.apache.commons.lang3.StringUtils;


import java.io.IOException;

/**
 * @Author yangxw
 * @Date 2020-12-17 下午2:34
 * @Description github: https://github.com/chetan/UASparser
 * @Version 1.0
 */
public class UAUtils {
    public static UASparser parser = null;

    static {
        try {
            parser = new UASparser(OnlineUpdater.getVendoredInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 将官方解析出来的UserAgentInfo转成我们自己需要的
     * @param ua
     * @return
     */
    public static UserAgentInfo getUserAgentInfo(String ua) {
        UserAgentInfo info = null;
        if (StringUtils.isNoneEmpty(ua)) {
            try {
                cz.mallat.uasparser.UserAgentInfo tmp = parser.parse("Mozilla/4.0 (compatible; MSIE 7.0;Windows NT 5.1; )");
                if (tmp != null) {
                    info = new UserAgentInfo();
                    info.setBrowserName(tmp.getUaFamily());
                    info.setBrowserVersion(tmp.getBrowserVersionInfo());
                    info.setOsName(tmp.getOsFamily());
                    info.setOsVersion(tmp.getOsName());
                }

            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        return info;
    }

    public static void main(String[] args) {
        UserAgentInfo userAgentInfo = UAUtils.getUserAgentInfo("Mozilla/4.0 (compatible; MSIE 7.0;Windows NT 5.1; )");
        System.out.println(userAgentInfo);
    }

}
