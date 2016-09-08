package com.scofevil.test.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    static class Task implements Runnable {

        private Socket socket;

        public Task(Socket socket) {
            this.socket = socket;
        }

        //使用BufferReader来一次读一行
        private void handleSocket_1() throws Exception {
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            StringBuilder sb = new StringBuilder();
            String temp;
            int index;
            while ((temp = br.readLine()) != null) {
                System.out.println(temp);
                if ((index = temp.indexOf("eof")) != -1) {
                    sb.append(temp.substring(0, index));
                }
                sb.append(temp);
            }
            System.out.println("from client: " + sb);
            Writer writer = new OutputStreamWriter(socket.getOutputStream());
            writer.write("Hello Client.");
            writer.write("eof\n");
            writer.flush();
            writer.close();
            br.close();
            socket.close();
        }

        //普通读法
        private void handleSocket() throws Exception {
            Reader reader = new InputStreamReader(socket.getInputStream());
            char[] chars = new char[64];//这里使用64下面的read就会一次读去6个字符
            int len;
            StringBuilder sb = new StringBuilder();
            String temp;
            int index;
            while ((len = reader.read(chars)) != -1) {//如果如果客户端一直没有往输出流写内容，程序也会一直阻赛在这里直到客户端写内容
                temp = new String(chars, 0, len);
                if ((index = temp.indexOf("eof")) != -1) {//遇到eof时就结束接收
                    sb.append(temp.substring(0, index));
                    break;
                }
                sb.append(new String(chars, 0, len));
            }
            System.out.println("from client:" + sb);
            System.out.println();
            //读完之后写一句
            Writer writer = new OutputStreamWriter(socket.getOutputStream());
            writer.write("Hello Client.");
            writer.write("eof");
            writer.flush();
            writer.close();
            reader.close();
            socket.close();
        }

        public void run() {
            try {
                handleSocket_1();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    public static void main(String[] args) {
        int port = 8899;
        //定义一个ServerSocket监听在8899端口上面
        ServerSocket server;
        try {
            server = new ServerSocket(port);
            while (true) {
                //server尝试接收其他Socket的连接请求，server的accept方法是阻赛式的
                Socket socket = server.accept();//如果这里一直没有客户端来请求，程序会一直阻赛在这里直到有客户端来请求
                //跟客户端建立好连接之后，我们就可以获取socket的InputStream，并从中读取客户端发过来的信息了。
                new Thread(new Task(socket)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
