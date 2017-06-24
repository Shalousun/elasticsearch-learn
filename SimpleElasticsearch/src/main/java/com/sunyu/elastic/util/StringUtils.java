package com.sunyu.elastic.util;

import com.alibaba.fastjson.JSONObject;

import java.util.Map;

/**
 * Created by yu on 2017/6/25.
 */
public class StringUtils {
    /**
     * 将Map转换成json字符串
     *
     * @param map Map<String, Object>格式数据
     * @return json数据
     */
    public static String map2String(Map<String, Object> map) {
        return JSONObject.toJSONString(map);
    }

    /**
     * 首字母转小写
     *
     * @param s 待转换的字符串
     * @return
     */
    public static String toLowerCaseFirstOne(String s) {
        if (Character.isLowerCase(s.charAt(0))){
            return s;
        } else{
            return (new StringBuilder()).append(Character.toLowerCase(s.charAt(0))).append(s.substring(1)).toString();
        }
    }
}
