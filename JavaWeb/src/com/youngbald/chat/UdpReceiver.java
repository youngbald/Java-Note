package com.youngbald.chat;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UdpReceiver {
    public static void main(String[] args)throws Exception {
        DatagramSocket socket = new DatagramSocket(6666);
        //ready to receive pack'

        while(true){
            byte[] container = new byte[1024];
            DatagramPacket packet = new DatagramPacket(container,0, container.length);
            socket.receive(packet);

            byte[] data = packet.getData();
            String recievedata= new String(data,0,data.length);
            System.out.println(recievedata);

            if(recievedata.equals("Bye")){
                break;
            }

        }

        socket.close();

    }
}
