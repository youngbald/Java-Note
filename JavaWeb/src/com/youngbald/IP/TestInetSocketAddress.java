package com.youngbald.IP;

import java.net.InetSocketAddress;

//套接字
public class TestInetSocketAddress {
    public static void main(String[] args) {
        InetSocketAddress in1 = new InetSocketAddress("127.0.0.1",8080);
        InetSocketAddress in2 = new InetSocketAddress("localhost",8080);

        System.out.println(in1);
        System.out.println(in2);
        System.out.println(in1.getAddress());
        System.out.println(in2.getAddress());
        System.out.println(in2.getHostName());//地址
        System.out.println(in1.getPort());//端口
    }
}
