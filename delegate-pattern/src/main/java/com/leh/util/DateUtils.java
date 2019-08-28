/*
 * Copyright (C), 2018-2019, tsfa
 * FileName: DateUtils.java
 * Author:   lijq
 * Date:     2018/8/2  11:49
 * Description:
 * History: 修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名     修改时间      版本号        描述
 */
package com.leh.util;

import org.apache.commons.lang.StringUtils;
import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.Period;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.util.Date;

/**
 * 日期工具类<br>
 * 〈功能详细描述〉
 *
 */
public class DateUtils {

    /**
     * yyyy
     */
    public static final String FORMAT_YEAR = "yyyy";

    /**
     * yyyyMMdd
     */
    public static final String FORMAT_DATE = "yyyyMMdd";

    /**
     * yyyy-MM-dd
     */
    public static final String FORMAT_DATE_2 = "yyyy-MM-dd";

    /**
     * yyyy-MM-dd HH:mm:ss
     */
    public static final String FORMAT_DATE_DETAIL = "yyyy-MM-dd HH:mm:ss";

    /**
     * yyyyMMddHHmmss
     */
    public static final String FORMAT_DATE_DETAIL_2 = "yyyyMMddHHmmss";

    private DateUtils() {
        throw new IllegalStateException("DateUtils class");
    }

    /**
     * 日期字符串转化为Date类型
     *
     * @param datetime 日期字符串
     * @param pattern  表达式
     * @return Date
     */
    public static Date parse(String datetime, String pattern) {
        if (StringUtils.isBlank(datetime)) {
            return null;
        }
        if (StringUtils.isBlank(pattern)) {
            return null;
        }
        return parseToDateTime(datetime, pattern).toDate();
    }

    /**
     * 日期字符串转化成另一种日期字符串
     *
     * @param datetime   日期字符串
     * @param oriPattern 原来日期字符串格式
     * @param destPatter 目标日期字符串格式
     * @return 目标日期字符串
     */
    public static String toString(String datetime, String oriPattern, String destPatter) {
        if (StringUtils.isBlank(datetime)) {
            return null;
        }
        if (StringUtils.isBlank(oriPattern)) {
            return null;
        }
        if (StringUtils.isBlank(destPatter)) {
            return null;
        }
        DateTime dateTime = parseToDateTime(datetime, oriPattern);
        return dateTime.toString(destPatter);
    }

    /**
     * 把日期转换字符串
     *
     * @param date    日期
     * @param pattern 日期字符串格式
     * @return 字符串格式
     */
    public static String toString(Date date, String pattern) {
        if (date == null) {
            return null;
        }
        DateTime dateTime = new DateTime(date);
        return dateTime.toString(pattern);
    }

    private static DateTime parseToDateTime(String datetime, String pattern) {
        DateTimeFormatter formatter = DateTimeFormat.forPattern(pattern);
        return DateTime.parse(datetime, formatter);
    }

    /**
     * 日期加上某些天
     *
     * @param date 日期
     * @param days 天数
     * @return 新的日期
     */
    public static Date plusDays(Date date, int days) {
        if (date == null) {
            return null;
        }
        DateTime dateTime = new DateTime(date);
        dateTime = dateTime.plusDays(days);
        return dateTime.toDate();
    }

    /**
     * 日期减去某些天
     *
     * @param date 日期
     * @param days 天数
     * @return 新的日期
     */
    public static Date minusDays(Date date, int days) {
        if (date == null) {
            return null;
        }
        DateTime dateTime = new DateTime(date);
        dateTime = dateTime.minusDays(days);
        return dateTime.toDate();
    }

    /**
     * 获得两个日期相差天数
     *
     * @param start 开始时间
     * @param end   结束时间
     * @return 相差天数
     */
    public static int getMinusDays(Date start, Date end) {
        if (start == null) {
            throw new IllegalArgumentException("start date must not be null");
        }

        if (end == null) {
            throw new IllegalArgumentException("end date must not be null");
        }

        DateTime startTime = new DateTime(start);

        DateTime endTime = new DateTime(end);

        return Days.daysBetween(startTime, endTime).getDays();
    }

    /**
     * 获得两个日期相差月数
     *
     * @param start 开始时间
     * @param end   结束时间
     * @return 相差月数
     */
    public static int getMinusMonths(Date start, Date end) {
        Period period = getPeriod(start, end);
        if (period == null) {
            return 0;
        }
        return period.getMonths();
    }

    /**
     * 获得两个日期相差年份
     *
     * @param start 开始时间
     * @param end   结束时间
     * @return 相差月数
     */
    public static int getMinusYears(Date start, Date end) {
        Period period = getPeriod(start, end);
        if (period == null) {
            return 0;
        }
        return period.getYears();
    }

    private static Period getPeriod(Date start, Date end) {
        if (start == null) {
            return null;
        }
        DateTime startTime = new DateTime(start);

        if (end == null) {
            return null;
        }
        DateTime endTime = new DateTime(end);

        return new Period(startTime, endTime);
    }
}
