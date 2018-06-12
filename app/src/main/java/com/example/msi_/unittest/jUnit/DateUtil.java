package com.example.msi_.unittest.jUnit;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * 创建者：ZC
 * 创建日期： 2018/6/12 13:54
 * 描述：用于测试JUnit
 **/
public class DateUtil {
    public final static String FORMAT_YMDHMS = "yyyy-MM-dd HH:mm:ss";

    /**
     * 将时间从String转换到long类型
     * @param time
     * @return
     * @throws ParseException
     */
    public static long stringToStamp(String time) throws ParseException{
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(FORMAT_YMDHMS, Locale.CANADA);
        Date date = simpleDateFormat.parse(time);
        return date.getTime();
    }

    /**
     * 将时间从long转换为Date
     * @return
     * @throws ParseException
     */
    public static String stampToDate(long lt)throws ParseException{
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(FORMAT_YMDHMS,Locale.CANADA);
        Date date = new Date(lt);
        return simpleDateFormat.format(date);
    }
}
