package com.easy.util;

import org.apache.commons.lang3.StringUtils;

/**
 * @Author rzq
 * @Desc 字符串工具类
 * @Date 2020-02-21
 **/
public class StringUtil {

    /**
     * 判断字符串是否超长
     *
     * @param srcStr
     * @param maxLength
     * @return
     */
    public static boolean overLength(String srcStr, Integer maxLength) {
        if (StringUtils.isEmpty(srcStr)) {
            return false;
        }
        return srcStr.length() > maxLength;
    }
}
