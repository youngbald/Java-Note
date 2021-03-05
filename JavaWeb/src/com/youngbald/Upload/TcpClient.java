package com.youngbald.Upload;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.*;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class TcpClient {
    public static void main(String[] args) throws IOException {
        //1.create a socket
        Socket socket = new Socket(InetAddress.getByName("192.168.1.2"),9000);
        //2.create a output stream
        OutputStream os = socket.getOutputStream();
        //3.file stream
        FileInputStream fis = new FileInputStream(new File("omi.jpg"));
        //4. write file
        byte [] buffer= new byte[1024];
        int len ;
        while((len=fis.read(buffer))!=-1){
            os.write(buffer,0,len);
        }
//通知服务气，我已经结束了
        socket.shutdownOutput();//我已经传输完了

        //make sure the server is done receiving
//        then we close the connection
        InputStream inputstream = socket.getInputStream();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        byte [] buffer2 = new byte[1024];
        int len2;
        while((len2 =inputstream.read(buffer2))!=-1){
            baos.write(buffer2,0,len2);
        }

        System.out.println(baos.toString());


        //close
        baos.close();
        inputstream.close();
        fis.close();
        os.close();
        socket.close();
    }
}
