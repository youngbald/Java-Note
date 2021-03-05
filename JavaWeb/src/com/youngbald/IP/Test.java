package com.youngbald.IP;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.net.UnknownServiceException;

//测试IP
public class Test {
    public static void main(String[] args) {

            try {
                //查询本机地址 localhost
                InetAddress in1 = InetAddress.getByName("127.0.0.1");
                System.out.println(in1);

                InetAddress in3 = InetAddress.getLocalHost();
                System.out.println(in3);

                //查询网站地址
                InetAddress in2 = InetAddress.getByName("www.baidu.com");
                System.out.println(in2);
                System.out.println("c常用方法：");
                //常用方法
                System.out.println(in2.getAddress());
                System.out.println(in2.getCanonicalHostName());//规范的名字
                System.out.println(in2.getHostName());//域名
                System.out.println(in2.getHostAddress());//ip



            } catch (UnknownHostException e) {
                e.printStackTrace();
            } finally {
            }

    }
}
