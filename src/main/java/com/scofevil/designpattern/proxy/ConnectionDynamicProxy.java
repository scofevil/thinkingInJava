package com.scofevil.designpattern.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;

/**
 * @param
 * @author haifeng.lu
 * @see
 * @since 1.0
 */
public class ConnectionDynamicProxy implements InvocationHandler{

    private Connection connection;

    public ConnectionDynamicProxy(Connection connection){
        super();
        this.connection = connection;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //这里判断是connection接口的close方法
        if(Connection.class.isAssignableFrom(proxy.getClass()) && method.getName().equals("close")){
            //这里不真正执行close方法（method.invoke(connection,args))
            //而是将连接返回给连接池
            DataSource.getInstance().recoveryConnection(connection);
            System.out.println("这里不真正执行close方法（method.invoke(connection,args)),而是将连接返回给连接池");
            return null;
        } else {
            return method.invoke(connection, args);
        }
    }

    public Connection getConnectionProxy(){
        return (Connection) Proxy.newProxyInstance(getClass().getClassLoader(),new Class[]{Connection.class},this);
    }
}
