package com.zsc.generator.utils;

import cn.hutool.core.util.StrUtil;

/**
 * @author : xingpeng
 * @date : 2021-12-09 20:26
 **/
public class GenUtils {
    
    /**
     * 获取模块名
     *
     * @param packageName 包名
     * @return 模块名
     */
    public static String getModuleName(String packageName)
    {
        int lastIndex = packageName.lastIndexOf(".");
        int nameLength = packageName.length();
        String moduleName = StrUtil.sub(packageName, lastIndex + 1, nameLength);
        return moduleName;
    }
}
