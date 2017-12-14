package com.itsun.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author ysun9621@gmail.com
 * @date 2017/12/11
 * on SQLAutoFininshProject
 * on 15:59
 */
public class DateUtils {
    public synchronized  static String getNowTime(){
        DateTimeFormatter formatter =  DateTimeFormatter.ofPattern("MM-dd");
        return LocalDate.now().format(formatter);
    }
}
