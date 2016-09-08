package com.scofevil.test;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.net.Socket;

public class TestClient {
    public static void main(String[] args) throws IOException {
        String host = "127.0.0.1";
        int port = 8899;
        Socket client = new Socket(host, port);
        Writer writer = new OutputStreamWriter(client.getOutputStream());
        writer.write("Hello Server");
        writer.write("eof");
        writer.flush();
        Reader reader = new InputStreamReader(client.getInputStream());
        char[] chars = new char[64];
        int len;
        StringBuilder sb = new StringBuilder();
        String tmp;
        int index;
        while ((len = reader.read(chars)) != -1) {
            tmp = new String(chars, 0, len);
            if ((index = tmp.indexOf("eof")) != -1) {
                sb.append(tmp.substring(0, index));
                break;
            }
            sb.append(new String(chars, 0, len));
        }
        System.out.println("from server: " + sb);
        reader.close();
        writer.close();
        client.close();
    }
}
