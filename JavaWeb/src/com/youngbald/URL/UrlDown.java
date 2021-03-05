package com.youngbald.URL;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class UrlDown {
    public static void main(String[] args) throws IOException {
//        1.下载地址
        URL url = new URL("http://localhost:8080/youngbald/SecurityFile.txt");
//        2.连接到这个资源HTTP
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();

        InputStream inputStream = urlConnection.getInputStream();

        FileOutputStream fos = new FileOutputStream("SecurityFile.txt");

        byte[] buffer = new byte[1024];
        int len;
        while((len=inputStream.read(buffer))!=-1){
            fos.write(buffer,0,len);//写出这个数据
        }

        fos.close();
        inputStream.close();
        urlConnection.disconnect();//断开连接
    }
}
