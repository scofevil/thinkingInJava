package com.scofevil.test;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.net.ServerSocket;
import java.net.Socket;

public class TestSocket {
    public static void main(String[] args) throws IOException {
        int port = 8899;
        ServerSocket server = new ServerSocket(port);
        Socket socket = server.accept();
        Reader reader = new InputStreamReader(socket.getInputStream());
        char[] chars = new char[64];
        int len;
        String temp;
        int index;
        StringBuilder sb = new StringBuilder();
        while ((len = reader.read(chars)) != -1) {
            temp = new String(chars, 0, len);
            if ((index = temp.indexOf("eof")) != -1) {//遇到eof时就结束接收  
                sb.append(temp.substring(0, index));
                break;
            }
            sb.append(new String(chars, 0, len));
        }
        System.out.println("from client：" + sb);
        Writer writer = new OutputStreamWriter(socket.getOutputStream());
        writer.write("Hello Client.");
        writer.write("eof");
        writer.flush();
        writer.close();
        reader.close();

    }
}
