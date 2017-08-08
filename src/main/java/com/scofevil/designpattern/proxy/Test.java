package com.scofevil.designpattern.proxy;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author haifeng.lu
 * @since 1.0
 */
public class Test {
    public static void main(String[] args) throws SQLException {
        Connection c = DataSource.getInstance().getConnection(true);
        c.close();
        ConnectionDynamicProxy cc = new ConnectionDynamicProxy(
                DataSource.getInstance().getConnection(false));
        cc.getConnectionProxy().close();
        System.out.println(DataSource.getInstance().getConnectionList().size());
    }
}
