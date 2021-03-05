package com.youngbald.chat;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;

public class UdpSender {
    public static void main(String[] args)throws Exception {
        DatagramSocket socket = new DatagramSocket(8888);
        //准备数据： 控制台读取system。in
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while(true){
            String  data =  reader.readLine();
            byte[] buffer = data.getBytes();
            DatagramPacket packet = new DatagramPacket(buffer,0,buffer.length, new InetSocketAddress("localhost",6666));

            socket.send(packet);

            if(data.equals("Bye")){
                break;
            }
        }


        socket.close();
    }
}
