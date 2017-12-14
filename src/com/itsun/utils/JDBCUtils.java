package com.itsun.utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author ysun9621@gmail.com
 * @date 2017/12/11
 * on SQLAutoFininshProject
 * on 9:57
 */
public class JDBCUtils {

    private static final ComboPooledDataSource DATA_SOURCE = new ComboPooledDataSource();

    public  static  Connection getConnection(){
        Connection conn = null;

        try {
            conn = DATA_SOURCE.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return conn;
    }


    public static DataSource getDataSource(){
        return DATA_SOURCE;
    }




}
