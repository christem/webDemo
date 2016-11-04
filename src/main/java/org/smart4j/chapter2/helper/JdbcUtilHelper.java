package org.smart4j.chapter2.helper;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.smart4j.chapter2.util.CollectionUtil;
import org.smart4j.chapter2.util.PropsUtil;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * 数据库助手类
 */
public final class JdbcUtilHelper {

    private static final Logger LOGGER = LoggerFactory.getLogger(JdbcUtilHelper.class);

    private static final String driver;

    private static final String url;

    private static final String username;

    private static final String password;

    static {
        Properties conf = PropsUtil.loadProps("./org/smart4j/chapter2/config.properties");
        driver = conf.getProperty("jdbc.driver");
        url = conf.getProperty("jdbc.url");
        username = conf.getProperty("jdbc.username");
        password = conf.getProperty("jdbc.password");

        try{
            Class.forName(driver);
        }catch (ClassNotFoundException e) {
            LOGGER.error("can not load jdbc driver",e);
        }
    }

    /**
     * 获取数据库连接
     * @return
     */
    public  static  Connection getConnection(){
        Connection conn = null;
        try {
            conn= DriverManager.getConnection(url,username,password);
        }catch (Exception e){
            LOGGER.error("get connection failure",e);
        }
        return conn;
    }


    public static void closeConnection(Connection conn){
        if (conn!=null){
            try {
                conn.close();
            } catch (SQLException e) {
                LOGGER.error("close connection failure",e);
            }
        }
    }
}
