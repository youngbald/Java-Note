package com.youngbald.chat;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

public class TalkSend implements Runnable {

    private int fromPort;
    private String toIP;
    private int toPort;
    DatagramSocket socket = null;
    BufferedReader reader = null;

    public TalkSend(int fromPort, String toIP, int toPort) {
        this.fromPort = fromPort;
        this.toIP = toIP;
        this.toPort = toPort;
        try {
            socket = new DatagramSocket(fromPort);
            reader = new BufferedReader(new InputStreamReader(System.in));
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while(true){
            try{
                String data = reader.readLine();
                byte[] buffer  = data.getBytes();
                DatagramPacket packet = new DatagramPacket(buffer,0, buffer.length,new InetSocketAddress(this.toIP,this.toPort));
                socket.send(packet);
                if(data.equals("bye")){
                    break;
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        socket.close();
    }
}