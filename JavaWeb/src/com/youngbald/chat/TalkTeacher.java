package com.youngbald.chat;

import javax.swing.plaf.TableHeaderUI;
import java.net.SocketException;

public class TalkTeacher {
    public static void main(String[] args)  {
        new Thread(new TalkSend(5555,"localhost",8888)).start();
        new Thread(new TalkReceive(9999,"学生")).start();
    }
}
