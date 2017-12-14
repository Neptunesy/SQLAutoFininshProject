package com.itsun.Task;

import com.itsun.utils.DateUtils;
import com.itsun.utils.JDBCUtils;
import com.itsun.utils.PropetryUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayListHandler;

import java.io.*;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author ysun9621@gmail.com
 * @date 2017/12/11
 * on SQLAutoFininshProject
 * on 13:38
 */
public class Task1 implements Runnable  {

    @Override
    public void run() {

        QueryRunner runner = new QueryRunner(JDBCUtils.getDataSource());

        String sql = "SELECT user.cell,\",\" FROM quhuanqian.loan_payback lp,quhuanqian.borrow_request br, quhuanqian.user user where lp.request_id = br.id and br.user_id = user.id and lp.payback_date is null and lp.status = 1 and lp.source < 3 and (to_days(now())-to_days(lp.payback_plan_date) = 1) ";

        String filePath = PropetryUtil.getProperty("filePath");

        String fileName = DateUtils.getNowTime() + "C0";

        File outFile = new File(filePath+fileName);


        try {
            FileOutputStream fop = new FileOutputStream(outFile);
            OutputStreamWriter writer = new OutputStreamWriter(fop, "UTF-8");

            List<Object[]> resultList = runner.query(sql,new ArrayListHandler());

            for (Object[] objects : resultList) {
                String s = Arrays.toString(objects);
                String[] split = s.split(",");
                for (String str : split) {
                    writer.append(str);
                    writer.append(" ,\n");
                }
            }
            writer.close();
            fop.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


    public static void main(String[] args) {

//        Task1 task1 = new Task1();
//            Thread thread = new Thread(task1);
//            thread.run();

//        System.out.println(outResult);

//        System.out.println(localDate);

        QueryRunner runner = new QueryRunner(JDBCUtils.getDataSource());

        String sql = "SELECT user.cell,\",\" FROM quhuanqian.loan_payback lp,quhuanqian.borrow_request br, quhuanqian.user user where lp.request_id = br.id and br.user_id = user.id and lp.payback_date is null and lp.status = 1 and lp.source < 3 and (to_days(now())-to_days(lp.payback_plan_date) = 1) ";

        String filePath = PropetryUtil.getProperty("filePath");

        String fileName = DateUtils.getNowTime() + "C0";

        File outFile = new File(filePath+"/"+fileName+".txt");


        try {
            FileOutputStream fop = new FileOutputStream(outFile);
            OutputStreamWriter writer = new OutputStreamWriter(fop, "UTF-8");

            List<Object[]> resultList = runner.query(sql,new ArrayListHandler());

            for (Object[] objects : resultList) {
                String s = Arrays.toString(objects);
                String[] split = s.split(",");
                for (String str : split) {
                    writer.append(str);
                    writer.append("\r\n");

                }
            }
            writer.close();
            fop.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
