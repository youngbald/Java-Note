package com.youngbald.TCP;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

//服务端
public class Server {
    public static void main(String[] args) {
        ServerSocket serverSocket=  null;
        Socket socket = null;
        InputStream is = null;
        ByteArrayOutputStream baos = null;
        try {

            //我有一个地址
            serverSocket = new ServerSocket(9999);
            while(true){
                socket  = serverSocket.accept();
                //3.读取客户端的消息
                is = socket.getInputStream();
//            管道流
                baos = new ByteArrayOutputStream();
                byte[] buffer = new byte[1024];
                int len;
                while((len=is.read(buffer))!=-1){
                    baos.write(buffer,0,len);
                }
                System.out.println(baos.toString());
            }
            //2.等待客户端连接过来





        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            //            关闭资源

            if(baos!=null) {
                try {
                    baos.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if(is!=null){
            try {
                is.close();
            } catch (IOException e) {
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
            if(serverSocket!=null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
