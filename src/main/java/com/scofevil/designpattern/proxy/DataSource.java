package com.scofevil.designpattern.proxy;

import org.springframework.util.CollectionUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.LinkedList;

/**
 * @author haifeng.lu
 * @since 1.0
 */
public class DataSource {

    private static LinkedList<Connection> connectionList = new LinkedList<>();
    private static DataSource dataSource = new DataSource();

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private DataSource() {
        if (CollectionUtils.isEmpty(connectionList)) {
            for (int i = 0; i < 10; i++) {
                try {
                    connectionList.add(createNewConnection());
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static Connection createNewConnection() throws SQLException {
        String url = "jdbc:mysql://db.iwjwdev.com:3306/hims_test?useUnicode=true&characterEncoding=UTF-8&autoReconnect=true";
        String name = "root";
        String psw = "Manyi@123";
        return DriverManager.getConnection(url, name, psw);
    }

    public static DataSource getInstance() {
        return dataSource;
    }

    public synchronized Connection getConnection(boolean useStaticProxy) {
        if (!CollectionUtils.isEmpty(connectionList)) {
            //return connectionList.remove();  这是原有的方式，直接返回连接，这样可能会被程序员把连接给关闭掉
            //下面是使用代理的方式，程序员再调用close时，就会归还到连接池
            if (useStaticProxy)
                return new ConnectionProxy(connectionList.remove());
            else
                return connectionList.remove();
        }
        return null;
    }

    public synchronized void recoveryConnection(Connection connection) {
        //close方法调用此方法将数据库连接返回给连接池
        connectionList.add(connection);
    }

    public LinkedList<Connection> getConnectionList() {
        return connectionList;
    }
}
