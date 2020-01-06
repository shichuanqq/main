package com.example.service.utils;

import org.apache.commons.lang3.time.DateFormatUtils;

import java.util.Date;


public class DateUtils {

    private final static String DATE_TIME_FORMAT = "yyyymmddhhmmss";

    private final static String DATE_TIME_FORMAT_1 = "yyyy-MM-dd HH:mm:ss";

    public static void main(String[] args) {
    }

    /**
     * date 类型转为 字符串
     * @param date
     * @return
     */
    public static String format(Date date){
        return DateFormatUtils.ISO_DATE_FORMAT.format(new Date());
    }

    /**
     * str 转为 date
     * @param str
     * @return
     */
    public static Date parse(String str){
        return null;
    }
}
