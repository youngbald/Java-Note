package com.youngbald.Upload;

import jdk.internal.util.xml.impl.Input;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class TcpServer {
    public static void main(String[] args) throws IOException {
        //1.create a socket server
        ServerSocket serverSocket = new ServerSocket(9000);
        //2.waiting listen
       Socket socket =  serverSocket.accept(); //keep waiting for client connect
        //3.get input stream
        InputStream is = socket.getInputStream();
        //4.file output
        FileOutputStream fos = new FileOutputStream(new File("receive.jpg"));

        byte[] buffer = new byte[1024];
        int len;
        while((len=is.read(buffer))!=-1){
            fos.write(buffer,0,len);
        }


        //通知客户端我接受完毕了
        OutputStream os = socket.getOutputStream();
        os.write("you can now disconnect".getBytes());

        //close window
        fos.close();
        is.close();
        socket.close();
        serverSocket.close();
    }
}
