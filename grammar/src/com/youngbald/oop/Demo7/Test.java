package com.youngbald.oop.Demo7;

public class Test {

    public static void main(String[] args) {
        //没有名字初始化类，不需要将实例保存到变量中
        //匿名内部类
        new Apple().app();
        User user = new User(){

            @Override
            public void interact() {

            }
        };
    }
}


class Apple{
    public void app(){
        System.out.println("eat an apple");
    }
}

interface User{
    void interact();
}