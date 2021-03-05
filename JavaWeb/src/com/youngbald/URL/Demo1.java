package com.youngbald.URL;

import java.net.MalformedURLException;
import java.net.URL;

public class Demo1 {
    public static void main(String[] args) throws MalformedURLException {
       URL url =  new URL("http://localhost:8080/helloworld/index.jsp?username=youngbald&password=123");
        System.out.println(url.getProtocol());//协议
        System.out.println(url.getHost());//主机ip
        System.out.println(url.getPort());//端口
        System.out.println(url.getFile());//文件
        System.out.println(url.getPath());//路径
        System.out.println(url.getQuery());//参数
    }
}
