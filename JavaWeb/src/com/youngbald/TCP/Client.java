package com.youngbald.TCP;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;

//客户端
public class Client {
    public static void main(String[] args) {
        Socket socket = null;
        OutputStream os= null;

        //1.要知道服务器的地址
        try {
          InetAddress  serverIP = InetAddress.getByName("192.168.1.2");
            //2.编口号
            int port = 9999;
            //创建一个socket连接
           socket = new Socket(serverIP,port);
            //发送消息 IO流
            os  = socket.getOutputStream();
            os.write("你好，这里来自socket".getBytes());

        } catch (Exception e) {
            e.printStackTrace();
        }
        finally{
            if(os!=null) {
                try {
                    os.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if(socket!=null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}
