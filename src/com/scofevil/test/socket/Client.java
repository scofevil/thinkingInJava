package com.scofevil.test.socket;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
    public static void main(String[] args) {
        String host = "127.0.0.1";//要连接的服务端IP地址
        int port = 8899;//要连接服务端对应的监听端口
        //与服务端建立连接
        try {
            Socket client = new Socket(host, port);
            client.setSoTimeout(4000);
            Writer writer = new OutputStreamWriter(client.getOutputStream());
            boolean flag = true;
            int i = 0;
            while (flag) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                writer.write("Hello Server " + i++);
                writer.write("eof\n");
                writer.flush();
            }

            //writer.close();d
            //client.close();
            //写完以后进行读操作
            Reader reader = new InputStreamReader(client.getInputStream());
            char[] chars = new char[64];
            int len;
            String temp;
            int index;
            StringBuilder sb = new StringBuilder();
            while ((len = reader.read(chars)) != -1) {
                temp = new String(chars, 0, len);
                if ((index = temp.indexOf("eof")) != -1) {
                    sb.append(temp.substring(0, index));
                    break;
                }
                sb.append(temp);
            }
            System.out.println("from server: " + sb);
            reader.close();
            writer.close();
            client.close();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
