# java多线程 Thread

目录

线程简介

线程实现

线程状态

线程同步

线程通信问题

高级主题



## 线程简介

多任务

同时做多件事情，看起来是多个任务都在做，其实本质上我们的大脑在同一时间依旧只做了一件事情

原来是一条路，因为车多了，道路堵塞，效率极低

为了提高使用的效率，能够充分利用道路，于是多加了车道

在操作系统中运行的程序就是进程，比如qq，播放器，游戏，ide

Process与Thread

- 程序，是指令和数据的有序集合，其本身没有任何运行的含义，是一个静态的概念
- 而进程则是执行程序的一次执行过程，它是一个动态的概念。是系统资源分配的单位
- 通常在一个进程中可以包含若干个线程，当然一个进程中至少又一个线程，不然没有存在的意义。线程是CPU调度和执行的单位

很多多线程是模拟出来的，真正的多线程是指有多个cpu，即多核，如服务器。如果是模拟出来的多线程，即在一个cpu的情况下，在同一个时间的，cpu只能执行一个代码，因为切换的很快，所以就有同时执行的错觉



核心概念

- 线程就是独立的执行路径；
- 在程序运行时，即使没有自己创建线程，后台也会有多个线程，如主线程，gc线程；
- main（）称之为主线程，为系统的入口，用于执行整个程序
- 在一个进程中，如果开启了多个线程，线程的运行由调度器安排调度，调度器是与操作系统紧密相关的，先后顺序是不能认为的干预的。
- 对同一份资源操作时，会存在资源抢夺的问题，需要加入并发控制
- 线程会带来额外的开销，如cpt调度时间，并发控制开销
- 每个线程在自己的工作内存交互，内存控制不当会造成数据不一直





## 线程创建

thread class ：继承Thread类

runnable 接口： 实现runnable接口

callable 接口 ：实现callable接口

- 自定义线程类继承Thread类
- 重写Run（）方法，编写线程执行体
- 创建线程对象，调用start（）方法启动线程



线程不一定立即执行，CPU安排调度

```java
package com.youngbald.Demo1;

//创建线程方式1 ：继承thread类，重写run方法
//总结：注意，线程开启不一定立即执行，由cpu调度执行
public class TestThread extends Thread{
    @Override
    public void run() {
        //run 方法线程
        for (int i = 0; i < 200; i++) {
            System.out.println("我在看代码 "+i);
        }
    }



    public static void main(String[] args) {
//        创建一个线程对象
        TestThread thread1 = new TestThread();

//        调用start（）方法开启线程
        thread1.start();


//        主线程



        for (int i = 0; i < 1000; i++) {
            System.out.println("我在学习多线程 "+i);
        }
    }

}

```





## 网图下载

```java
package com.youngbald.Demo1;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;

//练习Thread，实现多线程同步下载图片
public class TestThread2 extends Thread{
    private String url; //地址
    private String name;//保存的文件名

    public TestThread2(String url,String name){
        this.url = url;
        this.name =name;
    }



    @Override
    public void run() {
        webDownloader webDownloader = new webDownloader();
        webDownloader.downloader(url,name);
        System.out.println("下载了文件名为：  " +name);

    }


    public static void main(String[] args) {
        TestThread2 t1 = new TestThread2("https://images2018.cnblogs.com/blog/1188579/201807/1188579-20180713085655669-12680411.png","p1.jpg");
        TestThread2 t2 = new TestThread2("https://img95.699pic.com/photo/40048/6416.jpg_wh300.jpg","p2.jpg");
        TestThread2 t3 = new TestThread2("https://pic1.zhimg.com/v2-66537be2d1bcc380b5326b92f0c5fca3_1440w.jpg?source=172ae18b","p3.jpg");

        t1.start();
        t2.start();
        t3.start();


    }
}



//下载器
class webDownloader{
    public void downloader(String url,String name){
        try {
            FileUtils.copyURLToFile(new URL(url),new File(name));
        } catch (IOException e) {
            System.out.println("IO异常，donwloader方法出现问题");
        }
    }
}
```

期间下载了commons -io下载文件

是个处理文件的lib





## 龟兔赛跑

1. 首先来个赛道具体，然后要离重点越来越近
2. 判断比赛是否结束
3. 打印出胜利者
4. 龟兔赛跑开始
5. 故事中乌龟是赢的，兔子需要睡觉，所以我们来模拟兔子睡觉
6. 终于，乌龟赢得比赛

```java
package com.youngbald.Demo1;
//模拟龟兔赛跑
public class Race implements Runnable{
    private static String winner;
//    int steps= 0;
    @Override
    public void run() {
        for (int i = 0; i <= 100; i++) {
            //模拟兔子休息

            if(Thread.currentThread().getName().equals("rabbit")&&i%10==0){
                try {
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

                //判断比赛是否结束
            boolean flag = gameOver(i);
            if(flag) break; //game over process over
            System.out.println(Thread.currentThread().getName()+" --> 跑了"+ i+"步");
        }
    }


    //判断是否完成比赛
    private boolean gameOver(int steps){
        //判断是否由胜利者
        if(winner!=null){//已经存在胜利者了
            return true;
        }
        if(steps>=100){
            winner = Thread.currentThread().getName();
            System.out.println("winner is "+ winner);
            return true;
        }

        return false;

    }

    public static void main(String[] args) {
        Race race =new Race();

        new Thread(race,"rabbit").start();
        new Thread(race,"turtle").start();
    }
}

```





## 实现Callable接口

1. 实现Callable接口，需要返回值类型
2. 重写call方法，需要抛出异常
3. 创建目标对象
4. 创建执行服务：ExcutorServer ser = Executors.newFixedThreadPool(1);
5. 提交执行：Future<Boolean> result1 = ser.submit(t1);
6. 获取结果：boolean r1 = result1.get()
7. 关闭服务：ser.shutdownNow();

callable的好出

1. 可以定义返回值
2. 可以抛出异常
3. 时间复杂一些
4. 步骤很简单

```java
package com.youngbald.Demo2;

import com.youngbald.Demo1.TestThread2;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.*;

//线程创建方式
public class TestCallable implements Callable<Boolean> {



    private String url; //地址
    private String name;//保存的文件名

    public TestCallable(String url,String name){
        this.url = url;
        this.name =name;
    }



    @Override
    public Boolean call() {
       webDownloader webDownloader = new webDownloader();
        webDownloader.downloader(url,name);
        System.out.println("下载了文件名为：  " +name);
        return true;
    }


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        TestCallable t1 = new TestCallable("https://images2018.cnblogs.com/blog/1188579/201807/1188579-20180713085655669-12680411.png","p1.jpg");
        TestCallable t2 = new TestCallable("https://img95.699pic.com/photo/40048/6416.jpg_wh300.jpg","p2.jpg");
        TestCallable t3 = new TestCallable("https://pic1.zhimg.com/v2-66537be2d1bcc380b5326b92f0c5fca3_1440w.jpg?source=172ae18b","p3.jpg");

        //创建执行服务
        ExecutorService ser = Executors.newFixedThreadPool(3);


//        提交执行
        Future<Boolean> res1 = ser.submit(t1);
        Future<Boolean> res2 = ser.submit(t2);
        Future<Boolean> res3 = ser.submit(t3);
//                获取结果
        boolean r1 = res1.get();
        boolean r2 = res2.get();
        boolean r3 = res3.get();

        System.out.println(r1);
        System.out.println(r2);
        System.out.println(r3);
//        关闭服务
        ser.shutdown();
    }
}

//下载器
class webDownloader{
    public void downloader(String url,String name){
        try {
            FileUtils.copyURLToFile(new URL(url),new File(name));
        } catch (IOException e) {
            System.out.println("IO异常，donwloader方法出现问题");
        }
    }
}
```





## Lambda表达式

- lamda 希腊字母表中排序第是一位的字母，英语名称为lambda
- 避免匿名内部类定义过多
- 其实质属于函数式编程的概念

入

(params) -> expression[表达式]

(params) ->statement [语句]

(params) ->{statements}



为什么要使用lambda表达式

- 避免匿名内部类定义过多
- 可以让你的代码看起来很简洁
- 去掉了一堆没有意义的代码，只留下核心的逻辑

理解functional interface(函数式接口)是学习java8 lambda表达式的关键所在

函数式接口的定义:

- 任何接口， 如果只包含唯一一个抽象方法，那么它就是一个函数式接口

```java
public interface Runnable{
    public abstract void run();
}
```



- 对于函数式接口，我们可以通过lambda表达式来创建该接口的对象



**lambda表达式只能由一行代码的情况下才能简化成一行，如果由多行，那么就用代码块包裹。**

**前提是接口为函数式接口。接口只有一个函数**

**多个参数也可以去掉参数类型，要去掉就都去掉**，**必须加上括号**



lambda变形过程

```java
package com.youngbald.lambda;

//推导lambda表达式
public class TestLambda {


    //3.静态内部类
    static class Like2 implements ILike {


        @Override
        public void lambda() {
            System.out.println("I like lambda2");
        }
    }


//    main
    public static void main(String[] args) {
        ILike like= new Like();
        like.lambda();

        like = new Like2();
        like.lambda();

//        4.局部内部类
        class Like3 implements ILike {


            @Override
            public void lambda() {
                System.out.println("I like lambda3");
            }
        }

        like = new Like3();
        like.lambda();


//        5.匿名内部类,没有类的名称，必须借助接口或者父类
        like = new ILike() {
            @Override
            public void lambda() {
                System.out.println("I like lambda4");

            }
        };

        like.lambda();

//        6.用lambda简化
        like = ()->{
            System.out.println("I like lambda5");

        };
        like.lambda();
    }
}
//2.定义一个函数式接口
interface ILike{
    void lambda();
}

//2.实现类
class Like implements ILike {


    @Override
    public void lambda() {
        System.out.println("I like lambda");
    }
}
```

lambda不断简化

```java
package com.youngbald.lambda;

public class TestLambda2 {

    public static void main(String[] args) {
//      1.lambda表示简化
        Ilove love= (int a )->{

                System.out.println("I love you-->"+a );

        };

        love.love(1);


//        简化1.参数类型
        love  = (a)->{

            System.out.println("I love you-->"+a );

        };
        love.love(2);


//        简化2.简化括号
        love = a->{
            System.out.println("i love you-->"+a );
        };
        love.love(3);

//        简化3去掉花括号
        love = a-> System.out.println("i love you -->"+a);
        love.love(4);


    }
}

interface Ilove{
    void love(int a);
}


```



## 静态代理

- 你：真实角色
- 婚庆公司：代理你，帮你处理结婚的事
- 结婚：实现都实现结婚接口即可

```java
package com.youngbald;
//静态代理模式
public class StaticProxy {
    public static void main(String[] args) {
        WeddingCompany weddingCompany = new WeddingCompany(new You());
        weddingCompany.HappyMarry();
    }
}
interface  Marry{
    void HappyMarry();

    }

//真实角色，你去结婚
    class You implements Marry{

        @Override
        public void HappyMarry() {
            System.out.println("要结婚了");
        }
    }


    //代理角色，帮助你结婚
    class WeddingCompany implements Marry{
        private Marry target;
        public WeddingCompany(Marry target){
            this.target =target;
        }
        @Override
        public void HappyMarry() {
            before();
            this.target.HappyMarry();
            after();
        }

        private void after(){
            System.out.println("结婚之后");
        }
        private void before(){
            System.out.println("结婚之前");

        }
    }
```

总结：

- 真实对象和代理对象都要实现同一个接口
- 代理对象要代理真实角色



好处：

- 代理对象可以做很多真实对象做不了的事情
- 真实对象专注做自己的事情



```java
public class StaticProxy {
    public static void main(String[] args) {

        new Thread(()-> System.out.println("我哎你i")).start();
        new WeddingCompany(new You()).HappyMarry();
    }
}
```

上述两行代码相似







## 线程状态

### 线程停止



![img](https://cdn.nlark.com/yuque/0/2020/png/1281683/1596027546556-8d3fab8f-2ba4-4fb4-88f7-206f70b63f4f.png)

1. new： Thread t = new Thread（）线程对象一旦创建就进入到了新生状态
2. 当调用start（）方法，线程立即进入就绪状态，但不意味着立即调度执行
3. 就绪状态----运行状态：调度
4. 运行状态：进入运行状态，线程才真正执行县城提的代码块
5. 运行状态---阻塞状态：当调用sleep，wait或同步锁定时，线程进入阻塞状态，就是代码不往下执行，阻塞时间接触后，重新进入就绪状态，等待cpt调度执行
6. 运行状态---阻塞状态--就绪状态--运行状态--dead
7. dead:线程中断或者结束，一旦进入死亡状态，就不能再次启动



| 方法                           | 说明                                         |
| ------------------------------ | -------------------------------------------- |
| setPriority(int newPriority)   | 更改线程的优先级                             |
| static void sleep(long millia) | 在指定的毫秒数内让当前正在执行的线程休眠     |
| void join()                    | 等待该线程终止                               |
| static void yield()            | 暂停当前正在执行的线程对象，并执行其他的线程 |
| void interrupt()               | 中断线程，别用这个方式                       |
| boolean isAlive()              | 测试线程是否处于活动状态                     |



停止线程

- 不推荐使用jdk提供的stop、destroy方法，已废弃
- 推荐线程自己停止下来
- 建议使用一个标志位进行终止变量，当flag=false，则终止线程运行

```java
package com.youngbald.state;

//测试stop
//1，建议线程正常停止 利用次数，不建议死循环
//2.建议使用标志位, 设置一个标志位
//3.不要使用stop或者destroy等过时或者jdk不建议使用的方法
public class TestStop implements Runnable{
    //    1,设置一个标识位
    private boolean flag = true;


    @Override
    public void run() {
        int i = 0;
        while(flag){
            System.out.println("run...thread: "+ i++);
        }
    }

//    2.设置一个公开的方法停止线程,转换标志位
    public void stop(){
        this.flag =false;
    }

    public static void main(String[] args) {
        TestStop testStop = new TestStop();
        new Thread(testStop).start();
        for (int i = 0; i < 1000; i++) {
            System.out.println("main "+ i);
            if(i==900){
//                调用stop方法切换标志位,让线程停止
                testStop.stop();
                System.out.println("线程该停止了");
            }
        }
    }

}

```





### 线程休眠

- sleep（时间）指定当前线程阻塞的毫秒数
- sleep存爱异常InterruptExcetion；
- sleep时间达到后线程进入就绪状态
- sleep可以模拟网络延时，倒计时等
- 每一个对象都有一个锁，sleep不会释放锁



模拟网络延时 抢票

```jave
package com.youngbald.state;

//模拟网络延时:放大问题的发生性
public class TestSleep implements Runnable {
    private int ticketNum = 10;

    @Override
    public void run() {
    while(true){
        if(ticketNum<=0){
            break;
        }
//        模拟延时
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"-->拿到了第"+ ticketNum--+"票");
    }
    }


    public static void main(String[] args) {
        TestSleep tickt = new TestSleep();
        new Thread(tickt,"小明").start();
        new Thread(tickt,"老师").start();
        new Thread(tickt,"黄牛党").start();


    }
}

```

模拟当前时间：

```java

package com.youngbald.state;

import java.text.SimpleDateFormat;
import java.util.Date;

//模拟倒计时
public class TestSleep2 {
    public static void main(String[] args) throws InterruptedException {
//        打印当前系统时间
        Date startTime =new Date(System.currentTimeMillis()); //获取系统当前时间
        while(true){
            try {
                Thread.sleep(1000);
                System.out.println(new SimpleDateFormat("HH:mm:ss").format(startTime));
                startTime = new Date(System.currentTimeMillis());//更新当前时间
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void tenDown() throws InterruptedException {
        int num =10;
        while(true){
            Thread.sleep(1000);
            System.out.println(num--);
            if(num<=0){
                break;
            }
        }
    }
}

```



### 线程礼让

- 礼让线程，让当前正在执行的线程暂停，但不阻塞
- 将线程从运行状态转位就绪状态
- 让cpu重新调度，礼让不一定成功！看cpu心情



```java
package com.youngbald.state;

import sun.awt.windows.ThemeReader;

//测试礼让线程
//礼让不一定成功，看cpu心情
public class TestYield {
    public static void main(String[] args) {
        MyYield myYield = new MyYield();

        new Thread(myYield,"a").start();
        new Thread(myYield,"b").start();
    }
}


class MyYield implements Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"线程开始执行");
        Thread.yield();
        System.out.println(Thread.currentThread().getName()+"线程停止执行");
    }
}
```





### 线程插队

Join

- join合并线程，待此线程执行完成后，再执行其他线程，其他线程阻塞
- 可以想象成插队

```java
package com.youngbald.state;
//测试join方法、插队
public class TestJoin implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("线程vip来了"+i);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        TestJoin testJoin = new TestJoin();
        Thread thread = new Thread(testJoin);
        thread.start();

        //主线程
        for (int i = 0; i < 1000; i++) {
            if(i==200){
                thread.join();
            }
            System.out.println("main "+i);
        }
    }
}

```



### 线程状态观测

Thread.state：

线程状态。线程可以处于以下状态之一:

- New: 尚未启动的线程处于此状态
- Runnable：在java虚拟机中执行的线程处于此状态
- blocked：被阻塞等待监视器锁定的线程处于此状态
- timed_waitting:正在等待另一个线程执行动作达到指定等待时间的线程处于此状态
- terminated：已退出的线程处于此状态

一个线程可以在给定时间点处于一个状态。这些状态是不反应任何操作系统线程状态的虚拟机状态



```java
package com.youngbald.state;
//观察测试线程的状态
public class TestState {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(()->{
            for (int i = 0; i < 5; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("//////////////////");
        });


        //观察状态
        Thread.State state =thread.getState();
        System.out.println(state);
        //观察启动后
        thread.start();//启动线程
        state= thread.getState();
        System.out.println(state);//Run


        while(state != Thread.State.TERMINATED){//只要线程不终止，就一直输出状态
            Thread.sleep(100);
            state = thread.getState();//更新线程状态
            System.out.println(state);//输出状态
        }
        
        thread.start();//死亡之后的线程不能启动两次，所以这条会报错
    }
}

```



### 线程的优先级

- java提供一个线程调度器来监控程序中启动后进入就绪状态的所有线程，线程调度器按照优先级决定应该调度哪个线程来执行。
- 线程的优先级用数字表示，范围从1~10
  - Thread.MIN_PRIORITY =1;
  - Thread.MAX_PRIORITY=10;
  - Thread.NORM_PRIORITY =5;
- 使用以下方式改变或获取优先级
  - getPriority().setPriority(int xxx)



```java
package com.youngbald.state;

//测试线程的优先级
public class TestPriority{
    public static void main(String[] args) {
        //主线程默认优先级
        System.out.println(Thread.currentThread().getName()+"--->"+ Thread.currentThread().getPriority());
        MyPriority myPriority = new MyPriority();
        Thread t1 = new Thread(myPriority);
        Thread t2 = new Thread(myPriority);
        Thread t3 = new Thread(myPriority);
        Thread t4 = new Thread(myPriority);
        Thread t5 = new Thread(myPriority);
        Thread t6 = new Thread(myPriority);
        //先设置优先级，再激动
        t1.start();

        t2.setPriority(1);
        t2.start();

        t3.setPriority(4);
        t3.start();

        t4.setPriority(Thread.MAX_PRIORITY); //MAX_PRIORITY =10
        t4.start();

        t5.setPriority(8);
        t5.start();

        t6.setPriority(7);
        t6.start();
    }
}


class MyPriority implements Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"--->"+ Thread.currentThread().getPriority());
    }
}
```





**优先级低只是意味着获得调度的概率低。并不是优先级低就不会被调用了。这都是看cpu的调度**





### 守护线程 daemon

- 线程分为用户线程和守护线程
- 虚拟机必须确保用户线程执行完毕
- 虚拟机不用等待守护线程执行完毕
- 如：后台记录操作日志，监控内存，垃圾回收等待



```java
package com.youngbald.state;

//测试守护线程
//上帝守护你
public class TestDaemon {
    public static void main(String[] args) {
        God god = new God();
        You you = new You();

        Thread thread = new Thread(god);
        thread.setDaemon(true); //默认是false表示是用户线程，正常的线程都是用户线程

        thread.start();//上帝守护线程启动

        new Thread(you).start();//你 用户线程启动
    }
}


//上帝
class God implements Runnable{

    @Override
    public void run() {
        while(true){
            System.out.println("上帝保佑着你");
        }

    }
}

//你
class You implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 35600; i++) {
            System.out.println("你一声都开心的活着");
        }
        System.out.println("======goodby! wolrd!======");
    }
}

```



## 线程同步

多个线程操作同一个资源

并发：同一个对象被多个线程同时操作

- 现实生活中，我们会遇到“同一个资源，多个人都想使用”的问题，比如，食堂排队打饭，每个人都想吃饭，最天然的解决办法就是排队。一个个来
- 处理多线程问题时，多个线程访问同一个对象（并发），并且某些线程还想修改这个对象。这时候我们就需要**线程同步**。线程同步其实就是一种等待机制，多个需要同时访问此对象的线程进入这个**对象的等待池**形成队列，等待前面线程使用完毕，下一个线程再使用

形成条件：队列+锁



- 由于同一进程的多个线程共享同一块存储空间，再带来方便的哦同时木叶带来了访问冲突维妮塔，为了保证数据再方法中被访问时的正确性，再访问时加入锁机制synchronized，当一个线程获得对象的排它锁，独占资源，其他线程必须等待，使用后释放锁即可。存在以下问题：
  - 一个线程持有锁会导致其他所有需要此锁的线程挂起
  - 再多线程竞争下，加锁，释放锁会导致比较多的上下文切换和调度延时，引起性能问题；
  - 如果一个优先级高的线程等待一个优先级低的线程释放锁会导致优先级倒置，引起性能问题。

### 三大不安全案例

1. UnsafeBuyTicket:

   ```java
   package com.youngbald.syn;
   //不安全的买票
   //线程不安全，有负数
   public class UnsafeBuyTicket {
       public static void main(String[] args) {
           BuyTicket station = new BuyTicket();
   
           new Thread(station,"苦逼的我").start();
           new Thread(station,"牛逼的你").start();
           new Thread(station,"可恶的黄牛").start();
   
       }
   }
   
   class BuyTicket implements Runnable{
   //票
   
       private int ticketNums =10;
       boolean flag = true;//外部停止方式
   
       @Override
       public void run() {
           //买票
           while(flag){
               buy();
           }
       }
   
       private void buy(){
           //判断是否有票
   
   
           if(ticketNums<=0){
               flag = false;
               return;
           }
   
           //模拟延时
           try {
               Thread.sleep(100);
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
   
   
           //买票
           System.out.println(Thread.currentThread().getName()+"拿到了"+ticketNums--);
       }
   }
   ```

   

2. UnsafeBank:

   ```java
   package com.youngbald.syn;
   
   //不安全的取钱
   //两个人去银行取钱，账户
   public class UnsafeBank {
       public static void main(String[] args) {
          Account account = new Account(100,"youngbald存款");
   
   
          Drawing you= new Drawing(account,50,"youngbald");
          Drawing me = new Drawing(account, 100, "pang");
   
          you.start();
          me.start();
       }
   }
   //账户
   class Account{
       int money;
       String name;
   
       public Account(int money, String name) {
           this.money = money;
           this.name = name;
       }
   }
   
   //银行：模拟取款
   
   class Drawing extends Thread{
       Account account;//账户
       //取了多少钱
       int drawingMoney;
   //    现在手里有多少钱
       int nowMoney;
   
       public Drawing(Account account,int drawingMoney,String name){
           super(name);
           this.account = account;
           this.drawingMoney = drawingMoney;
          // this.name = name;
       }
   
   
       //取钱
   
   
       @Override
       public void run() {
           //判断有没有钱
           if(account.money-drawingMoney<0){
               System.out.println(Thread.currentThread().getName()+"没钱了取不了");
               return;
   
           }
   
           try {
               //sleep可以放大问题的安全性
               Thread.sleep(100);
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
           //卡内余额 = 余额- 你取的钱
           account.money =account.money-drawingMoney;
   //        你手里的钱
           nowMoney =nowMoney+drawingMoney;
           System.out.println(account.name+"余额为："+ account.money );
   
           System.out.println(this.getName()+"手里的钱: "+nowMoney);
   
   
       }
   }
   ```

   



3. UnsafeList

```java
package com.youngbald.syn;

import java.util.ArrayList;
import java.util.List;

//线程不安全的集合
public class UnsafeList {
    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            new Thread(()->{
                list.add(Thread.currentThread().getName());
            }).start();
        }
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(list.size());
    }
}

```





### 同步方法及同步块

- 由于我们可以通过private关键字来保证数据对象只能被方法访问，所以我们只需要针对方法提出一套机制，这套机制就是synchronized关键字，它包括两种用法：synchronized 方法和synchronized块。

  ```java
  同步方法
      public synchronized void method(int args){}
  ```

- synchronized方法控制对”对象“的访问，每个对象对应一把锁，每个synchronized方法都必须获得调用该方法的对象的锁才能执行，否则线程会阻塞， 方法一旦执行，就独占该锁，知道该方法返回才释放锁，后面被阻塞的线程才能获得这个锁，继续执行

**缺陷：若将一个大的方法申明为synchronized将会影响效率**

同步方法弊端

- 方法里面需要修改的内容才需要锁，锁得太多，浪费资源

只读跟可修改的区别

同步块：

- 同步块：synchronized(obj){}
- obj称之为同步监视器
  - obj可以是任何对象，但是推荐使用共享资源作为同步监视器
  - 同步方法中无需指定同步监视器，因为同步方法的同步监视器就是this，就是这个对象本身，或者是class【反射中讲解】
- 同步监视器的过程
  1. 第一个线程访问，锁定同步监视器，执行其中代码
  2. 第二个线程访问，发现同步监视器被锁定，无法访问
  3. 第一个线程访问完毕，解锁同步监视器
  4. 第二个线程访问，发现同步监视器没有锁，然后锁定并访问

修改后的代码

BuyTicket：

```java
package com.youngbald.syn;
//不安全的买票
//线程不安全，有负数
public class UnsafeBuyTicket {
    public static void main(String[] args) {
        BuyTicket station = new BuyTicket();

        new Thread(station,"苦逼的我").start();
        new Thread(station,"牛逼的你").start();
        new Thread(station,"可恶的黄牛").start();

    }
}

class BuyTicket implements Runnable{
//票

    private int ticketNums =10;
    boolean flag = true;//外部停止方式

    @Override
    public void run() {
        //买票
        while(flag){
            buy();
        }
    }
//同步方法，锁的是this
    private synchronized void buy(){
        //判断是否有票


        if(ticketNums<=0){
            flag = false;
            return;
        }

        //模拟延时
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        //买票
        System.out.println(Thread.currentThread().getName()+"拿到了"+ticketNums--);
    }
}

```



Bank:

```java
package com.youngbald.syn;

//不安全的取钱
//两个人去银行取钱，账户
public class UnsafeBank {
    public static void main(String[] args) {
       Account account = new Account(100,"youngbald存款");


       Drawing you= new Drawing(account,50,"youngbald");
       Drawing me = new Drawing(account, 100, "pang");

       you.start();
       me.start();
    }
}
//账户
class Account{
    int money;
    String name;

    public Account(int money, String name) {
        this.money = money;
        this.name = name;
    }
}

//银行：模拟取款

class Drawing extends Thread{
    Account account;//账户
    //取了多少钱
    int drawingMoney;
//    现在手里有多少钱
    int nowMoney;

    public  Drawing(Account account,int drawingMoney,String name){
        super(name);
        this.account = account;
        this.drawingMoney = drawingMoney;
       // this.name = name;
    }


    //取钱

//synchronized 默认锁的是this
    @Override
    public void run() {
//锁的对象就是变化的量，需要增删改查的量

        synchronized (account){
            //判断有没有钱
            if(account.money-drawingMoney<0){
                System.out.println(Thread.currentThread().getName()+"没钱了取不了");
                return;

            }

            try {
                //sleep可以放大问题的安全性
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //卡内余额 = 余额- 你取的钱
            account.money =account.money-drawingMoney;
//        你手里的钱
            nowMoney =nowMoney+drawingMoney;
            System.out.println(account.name+"余额为："+ account.money );

            System.out.println(this.getName()+"手里的钱: "+nowMoney);
        }



    }
}
```





List

```java
package com.youngbald.syn;

import java.util.ArrayList;
import java.util.List;

//线程不安全的集合
public class UnsafeList {
    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            new Thread(()->{
               synchronized (list) {
                   list.add(Thread.currentThread().getName());
               }
            }).start();
        }
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(list.size());
    }
}

```





CopyOnWriteArrayList

```java
package com.youngbald.syn;

import java.util.concurrent.CopyOnWriteArrayList;

//测试JUSC安全类型的集合
public class TestJUC {
    public static void main(String[] args) {
        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<String>();
        for (int i = 0; i < 10000; i++) {
            new Thread(()->{
                list.add(Thread.currentThread().getName());
            }).start();
        }

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(list.size());
    }
}

```





死锁

- 多个线程各自占有一些共享资源，并且互相等待其他线程占有的资源才能运行，而导致两个或者多个线程都再等待对方释放资源，都停止执行的情形。某一个同步块同时拥有”两个以上对象的锁“时，就可能会发生“死锁”的问题。

死锁的避免方法：

- 产生死锁的四个必要条件：

  1. 互斥条件：一个资源每次只能被一个进程使用。
  2. 请求于保持条件：一个进程因请求资源而阻塞时，对已获得的资源保持不妨。
  3. 不剥夺条件：进程已获得的资源，在未使用完之前，不能强行剥夺。
  4. 循环等待条件：若干进程之间形成一种头尾相接的循环等待资源关系。

  上面列出了死锁的四个必要条件，我们只要想办法破其中的任意一个或多个条件就可以避免死锁发生

```java
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

```

1号女生获得口红的锁。
2号女生获得镜子的锁。
1号女生1s钟后获得镜子的锁。
2号女生1s钟后获得口红的锁。



### Lock（锁）

- 从JDK 5.0开始，java提供了更强大的线程同步机制——通过显式定义同步锁对象来实现同步。同步锁使用Lock对象充当
- java.util.concurrent.locks.Lock 接口是控制多个线程对共享资源进行访问的工具。锁提供了对共享资源的独占访问，每次只能有一个线程对lock对象加锁，线程开始访问共享资源之前应先获得Lock对象
- reentrantLock类实现了Lock，它拥有于synchronized相同的并发现和内存语义，在实现线程安全的控制中，比较常用的是ReentrantLock，可以显式加锁、释放锁。

ReentrantLock 可重入锁



synchronized 与lock的对比

- lock是显式锁（手动开启和关闭锁，别忘记关闭锁）synchronized是隐式锁，出了作用域自动释放
- Lock只有代码块锁，synchronized有代码块锁和方法锁
- 使用Lock锁，JVM将花费较少的时间来调度线程，性能更好。并且具有更好的扩展性（提供更多的子类）
- 优先使用顺序：
  - Lock> 同步代码块（已经进入了方法体，分配了相应资源）>同步方法（在方法体之外）



```java
package com.youngbald.Demo1;

import com.sun.xml.internal.ws.api.ha.StickyFeature;

import java.util.concurrent.locks.ReentrantLock;

//测试lock锁
public class TestLock {
    public static void main(String[] args) {
        TestLock2 testLock2 = new TestLock2();
        new Thread(testLock2).start();
        new Thread(testLock2).start();
        new Thread(testLock2).start();
    }
}


class TestLock2 implements Runnable{
    int TicketNUm = 10;


//   定义锁
    private final ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        while(true) {

            try {
                lock.lock();
                if (TicketNUm > 0) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+TicketNUm--);
                }else{
                    break;
                }
            } finally {
                {
                    lock.unlock();
                }
            }
        }

    }
}
```





## 线程协作

生产者消费者模式 --》是个问题

- 应用场景：生产者和消费者问题

  - 假设仓库中只能存放一件产品，生产者将生产出来的产品放入仓库，消费者将仓库中产品取走消费。
  - 如果仓库中没有产品，则生产者将产品放入仓库，否则停止生产并等待，知道仓库中的产品被消费者取走位置。
  - 如果仓库中放有产品，则消费者可以将产品取走消费，否则停止消费并等待，知道仓库中再次放入产品为止。

  生产者--->数据缓存区--->消费者



线程通信-分析：

这个一个线程同步的问题，生产者和消费者共享同一个资源，并且生产者和消费者之间互相依赖，互为条件

- 对于生产者，没有生产产品之前，要通知消费者等待，而生产了产品之后，又需要马上通知消费者消费
- 对于消费者，在消费之后密钥通知生产者已经结束消费，需要生产新的产品以供消费。
- 在生产出消费者问题中，仅又synchronized是不够的
  - synchronized可以阻止并发更新同一个共享资源，实现了同步
  - synchronized 不能用来实现不同线程之间的消息传递（通信）



| 方法明             | 作用                                                         |
| ------------------ | ------------------------------------------------------------ |
| wait()             | 表示线程一直等待，知道其他线程通知，与sleep不同，会释放锁    |
| wait(long timeout) | 指定等待的毫秒数                                             |
| notify()           | 唤醒一个处于等待状态的线程                                   |
| notifyAll()        | 唤醒同一个对象上所有调用wait()方法的线程，优先级别高的线程优先调度 |



注意：**均是object类的方法，都只能在同步方法或者同步代码块中使用，否则会抛出异常Illegalmonitorstatexception**



解决方式1

并发协作模型“生产者/消费者模式” -->管程法

- 生产者：负责生产数据的模块（可能是方法，对象，线程，进程）；
- 消费者：负责处理数据的模块（）；
- 缓冲区：消费者不能直接使用生产者的数据，他们之间有个“缓冲区”

生产者将生产好的数据放入缓冲区，消费者从缓冲区拿出数据



解决方式2

并发协作模型“生产者/消费者模式” ——->信号灯法

true  - 等待

false -唤醒



### 管程法

```java
package com.youngbald.HighThread;
//测试：生产者消费者模型-> 利用缓冲区解决：管程法
//生产者，消费者，产品，缓冲区
public class TestPC {
    public static void main(String[] args) {
        SynContainer container = new SynContainer();
        new Producer(container).start();
        new Consumer(container).start();
    }
}

//生产者
class Producer extends Thread{
    SynContainer container;
    public Producer(SynContainer container){
        this.container = container;
    }

//    生产


    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            container.push(new Chicken(i));

            System.out.println("生产了"+ i+"只鸡");
        }
    }
}

//消费者
class Consumer extends Thread{
    SynContainer container;
    public Consumer(SynContainer container){
        this.container= container;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("消费了第-->"+container.pop().ID +"只鸡");

        }
    }
}

//产品
class Chicken{
    int ID;

    public Chicken(int ID) {
        this.ID = ID;
    }
}

//缓冲区
class SynContainer{
//    需要一个容器大小

    Chicken[] chickens = new Chicken[10];


//    容器计数器
    int count =0;
//    生产者放入产品
    public synchronized void push(Chicken chicken){
//        如果容器满了，就需要等待消费者消费
        if(count ==chickens.length){
//            通知消费者消费，生产者等待
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
//        如果没有满，我们就需要丢入产品
        chickens[count] = chicken;
        count++;
//        通知消费者消费了
        this.notifyAll();
    }

//    消费者消费产品
    public synchronized Chicken pop(){
//        判断能否消费
        if(count==0){
//            等待生产者生产，消费者等待
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
//        如果可以消费
        count--;
        Chicken chicken = chickens[count];
//        吃完了，通知生产者生产
        this.notifyAll();
        return chicken;
    }

}
```





### 信号灯

```java
package com.youngbald.HighThread;
//测试生产者消费者问题2： 信号灯法， 标志位解决

public class TestPC2 {
    public static void main(String[] args) {
        TV tv = new TV();
        new Player(tv).start();
        new Watcher(tv).start();
    }
}

//生产者——->演员
class Player extends Thread{
        TV tv;
        public Player(TV tv){
            this.tv = tv;
        }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            if(i%2==0){
                this.tv.play("快乐大本营播放中");
            }else{
                this.tv.play("抖音：记录美好生活");
            }
        }
    }
}
//消费者-->观众
class Watcher extends Thread{
    TV tv;
    public Watcher(TV tv){
        this.tv = tv;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            tv.watch();
        }
    }
}

//产品-->节目
class TV{
//    演员表演，观众等待
//    观众观看，演员等待
    String voice; //表演的节目
    boolean flag = true;
//    表演
    public synchronized void play(String voice){
        System.out.println("演员表演了："+ voice);
//        通知观众观看
        this.notifyAll();
        this.voice = voice;
        this.flag = !this.flag;

    }
//    观看
    public synchronized void watch(){
        if(!flag){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        if(flag){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("观看了："+ voice);
//        通知演员表演
        this.notifyAll();;
//        this.voice=voice;
        this.flag = !this.flag;
    }


}
```



## 使用线程池

- 背景：经常创建和销毁、使用量特别大的资源，比如并发情况下的线程，对性能影响很大。
- 思路：提前创建好多个线程，放入线程池中，使用时直接获取，使用完放回池中。可以避免频繁创建销毁、实现重复利用。类似生活中的公共交通工具
- 好处
  - 提高响应速度（减少了创建新线程的时间）
  - 降低资源消耗（重复利用线程池中线程，不需要每次都创建）
  - 便于线程管理（……）
    - corePoolSize：核心池的大小
    - maximumPoolSize：最大线程数
    - keepAliveTime：线程没有任务时最多保持多长时间后会终止



使用线程池

- JDk 5.0起提供了线程池相关API：excutorservice和executors
- executorservice：真正的线程池接口。常见子类THreadPoolExecutor
  - void execute(Runnable command):执行任务/命令，没有返回值，一般用来执行Runnable
  - <T> Future<T> submit(Callable<T>task):执行任务，没有返回值，一般又来执行Callable
  - void shutdown():关闭连接池
- Executor：工具类、线程池的工厂类，用于创建并返回不同类型的线程池