package com.test.platform.hawkeye.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTimeUtil {

    public static Date getCurrentDateTIme() {

        try {
            SimpleDateFormat df = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss" );//设置日期格式
            return df.parse( df.format( new Date() ) );
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return null;
    }
}
