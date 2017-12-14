package com.itsun.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 *
 * @author ysun9621@gmail.com
 * @date 2017/12/11
 * on SQLAutoFininshProject
 * on 15:35
 */
public class PropetryUtil {
    private static Properties properties;

    static {
        loadProps();
    }


    synchronized static private void loadProps() {
        properties = new Properties();
        InputStream in = null;
        try {
            //通过类加载器获取输入流，将配置文件读入
            in = PropetryUtil.class.getClassLoader().getResourceAsStream("config.properties");
            //载入这个配置文件
            properties.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            //检测输入流是否为空，不是的话关闭输入流
            if (in != null){
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 获取配置文件中的属性
     * @param key
     * @return  key对应的Value
     */
    public static String getProperty(String key){
        if (null == properties){
            loadProps();
        }
        return properties.getProperty(key);
    }

}
