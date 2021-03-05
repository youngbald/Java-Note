package com.youngbald.Demo1;
//死锁：两个多线程互相抱着对方需要的资源，然后形成僵持
public class DeadLock {
    public static void main(String[] args) {
        MakeUp g1 = new MakeUp(1, "1号女生");
        MakeUp g2 = new MakeUp(2, "2号女生");
         g1.start();
         g2.start();
    }
}


//口红
class LipStick{

}

//镜子
class Mirror{

}


//化妆

class MakeUp extends Thread{
//    需要的资源只有一份，用static保证只有一份
    static LipStick lipStick = new LipStick();
    static Mirror mirror = new Mirror();

    int choice;
    String name;//使用化妆品的人

    MakeUp(int choice, String name){
        this.choice = choice;
        this.name = name;
    }

    @Override
    public void run() {
        try {
            makeup();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
//    化妆，互相持有对方的锁，就是需要拿到对方的资源
    private void makeup() throws InterruptedException {
        if(choice==1){
            synchronized (lipStick){
                System.out.println(this.name+"获得口红的锁。");
                Thread.sleep(1000);

            }
//            如果此处的锁放在上面一个锁中形成内嵌关系 就会导致死锁
            synchronized (mirror){
                System.out.println(this.name+"1s钟后获得镜子的锁。");
            }
        }else{
            synchronized (mirror){
                System.out.println(this.name+"获得镜子的锁。");
                Thread.sleep(2000);

            } synchronized (lipStick){
                System.out.println(this.name+"1s钟后获得口红的锁。");
            }
        }



    }
    }
