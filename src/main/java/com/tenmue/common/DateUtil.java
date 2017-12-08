package com.tenmue.common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;

/**
 * 时间工具类
 * @author yang_yancy
 *
 */
public class DateUtil {

    private static DateUtil classInstance = new DateUtil();
    
    /**
     * yyyy-MM-dd HH:mm:ss
     */
    public static final String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";
    
    /**
     * yyyy-MM-dd HH:mm
     */
    public static final String YYYY_MM_DD_HH_MM = "yyyy-MM-dd HH:mm";
    
    /**
     * yyyy-MM-dd HH
     */
    public static final String YYYY_MM_DD_HH = "yyyy-MM-dd HH";
    
    /**
     * yyyy-MM-dd
     */
    public static final String YYYY_MM_DD = "yyyy-MM-dd";

    public static DateUtil getInstance() {
        return classInstance;
    }

    /**
     * 按指定格式对时间格式化
     * @param date	不允许为空
     * @param pattern	时间格式，如：yyyy-MM-dd HH:mm	not null
     * @return
     */
    public static String formatDate(Date date, String pattern) {
        if(date == null || StringUtils.isBlank(pattern)) {
        	return null;
        }

        return DateFormatUtils.format(date, pattern);
    }

    /**
     * 按默认时间格式化
     * 默认时间为：new Date()
     * @param pattern	时间格式，如：yyyy-MM-dd HH:mm	not null
     * @return
     */
    public static String formatDate(String pattern) {
    	if(StringUtils.isBlank(pattern)) {
    		return null;
    	}
        return DateFormatUtils.format(new Date(), pattern);
    }

    /**
     * 按指定格式将字符串时间转换为日期时间
     * @param dateString not null
     * @param pattern	not null
     * @return
     */
    public static Date parseDate(String dateString, String pattern) {
    	if(StringUtils.isBlank(dateString) || StringUtils.isBlank(pattern)) {
    		return null;
    	}
    	
    	try {
			return DateUtils.parseDate(dateString, pattern);
		} catch (ParseException e) {
			return null;
		}
    }
    
    /**
     * 格式化默认时间
     * 默认时间为：new Date()
     * @param pattern not null
     * @return
     */
    public static Date parseDate(String pattern) {
    	if(StringUtils.isBlank(pattern)) {
    		return null;
    	}
    	
    	try {
    		String dateString = formatDate(new Date(), pattern);
			return DateUtils.parseDate(dateString, pattern);
		} catch (ParseException e) {
			return null;
		}
    }

    /**
     * 时间比较
     * 开始时间、结束时间分别和目标时间做比较
     * @param srcDate	目标时间	not null
     * @param startDate	not null
     * @param endDate	not null
     * @return
     */
    public static boolean between(Date srcDate, Date startDate, Date endDate) {
        if (startDate.after(srcDate)) {
        	return false;
        }
        
        if (endDate.before(srcDate)) {
        	return false;
        }
        
        return true;
    }

    /**
     * 返回两时间比较
     * 
     * @param startDate
     * @param endDate
     * @return true:开始时间小于结束时间 false:开始时间大于结束时间
     */
    public static boolean between(Date startDate, Date endDate) {
        if (startDate.compareTo(endDate) <= 0) {
        	return true;
        }
        return false;
    }
    
    /**
     * 时间是否相等 
     * true:相等
     * false:不等
     * 
     * @param startDate	not null
     * @param endDate	not null
     * @return
     */
    public static boolean equalsDate(Date startDate, Date endDate) {
        if (startDate.compareTo(endDate) == 0) {
        	return true;
        }
        return false;
    }
    
    /**
     * 将unix时间格式转为指定格式时间
     * @param unixTime	只能是年月日时分秒,如果System.currentTimeMillis(),则需要除以1000		not null
     * @param pattern	时间格式:yyyy-MM-dd HH:mm:ss	not null
     * @return
     */
    public static String unixToLocalTime(long unixTime, String pattern) {
        return new SimpleDateFormat(pattern).format(new Date(unixTime * 1000));
    }
     
    /**
     * 本地时间转为unix时间
     * @param localTime	如：2016-08-22 15:58:30 not null
     * @param pattern	not null
     * @return
     */
    public static long localToUnixTime(String localTime, String pattern){
    	if(StringUtils.isBlank(localTime) || StringUtils.isBlank(pattern)) {
    		return 0;
    	}
    	
    	try {
    		return parseDate(localTime, pattern).getTime() / 1000;
		} catch (Exception e) {
			return 0;
		}
    }
    
    /**
     * 本地时间转为unix时间
     * @param date	not null
     * @return
     */
    public static long localToUnixTime(Date date) {
    	if(date != null) {
    		return date.getTime() / 1000;
    	}
    	
    	return 0;
    }
    
    /**
     * 增加年
     * 
     * @param date
     * @param year
     * @return
     */
    public static Date addYears(Date date, int year) {
    	if(date == null || year <= 0) {
    		return null;
    	}
    	
        return DateUtils.addYears(date, year);
    }

    /**
     * 增加月
     * 
     * @param date
     * @param month
     * @return
     */
    public static Date addMonths(Date date, int month) {
    	if(date == null || month <= 0) {
    		return null;
    	}
    	
        return DateUtils.addMonths(date, month);
    }
    
    /**
     * 增加天
     * 
     * @param date
     * @param day
     * @return
     */
    public static Date addDays(Date date, int day) {
    	if(date == null || day <= 0) {
    		return null;
    	}
    	
        return DateUtils.addDays(date, day);
    }

    /**
     * 给指定时间增加指定小时
     * 
     * @param date
     * @param hour
     * @return
     */
    public static Date addHours(Date date, int hour) {
    	if(date == null || hour <= 0) {
    		return null;
    	}
    	
        return DateUtils.addHours(date, hour);
    }

    /**
     * 获取指定时间的小时
     * 
     * @param date
     * @return
     */
    public static int getHours(Date date) {
    	if(date == null) {
    		return 0;
    	}
    	
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.HOUR_OF_DAY);
    }

    /**
     * 获取指定时间的分钟
     * 
     * @param date
     * @return
     */
    public static int getMinute(Date date) {
    	if(date == null) {
    		return 0;
    	}
    	
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.MINUTE);
    }

    /**
     * 获取日期差
     * 
     * @param startTime
     * @param endTime
     * @return
     */
    public static int getSubDays(Date startTime, Date endTime) {
    	if(startTime == null || endTime == null) {
    		return 0;
    	}
    	
        //86400000 = 24 * 60 * 60 * 1000
        return (int) ((endTime.getTime() - startTime.getTime()) / 86400000);
    }

    /**
     * 判断时间onlineTime是否在过去days天以内
     * 
     * @param date
     * @param days
     * @return
     */
    public static boolean isWithin(Date date, int days) {
        if (null == date || days <= 0) {
            return false;
        }
        return addDays(date, days).after(new Date());
    }
    
    /**
     * 获取两个日期之间的小时差值
     * @param beginDate
     * @param endDate
     * @return
     */
    public static int diffDateHour(Date beginDate, Date endDate){
    	if(beginDate == null || endDate == null) {
    		return 0;
    	}
    	
    	//两个时间差值的毫秒数
    	long diffMillis = endDate.getTime() - beginDate.getTime();
    	//将毫秒数转换成小时
    	int diffHour = Integer.parseInt((diffMillis / 1000 / 60 / 60) + "");
    	return diffHour;
    }
    
    /**
     * 获取两个日期之间的分钟差值
     * @param beginDate
     * @param endDate
     * @return
     */
    public static int diffDateMiute(Date beginDate, Date endDate){
    	if(beginDate == null || endDate == null) {
    		return 0;
    	}
    	
    	//两个时间差值的毫秒数
    	long diffMillis = endDate.getTime() - beginDate.getTime();
    	//将毫秒数转换成分钟
    	int diffMiute = Integer.parseInt((diffMillis / 1000 / 60) + "");
    	return diffMiute;
    }
	
    /**
     * 返回星期几
     * 
     * @param date not null
     * @return
     */
    public static String getWeekDayString(Date date) {
    	if(date == null) {
    		return null;
    	}
    	
        String dayNames[] = { "星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六" };
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        String weekString = dayNames[dayOfWeek - 1];
        return weekString;
    }
    
    /**
     * 是否周末
     * 
     * @param day
     * @return
     */
    public static boolean isWeekend(Date day) {
    	if(day == null) {
    		return false;
    	}
    	
        Calendar cal = Calendar.getInstance();
        cal.setTime(day);
        int week = cal.get(Calendar.DAY_OF_WEEK);
        return (Calendar.SATURDAY == week || Calendar.SUNDAY == week) ? true : false;
    }

}
