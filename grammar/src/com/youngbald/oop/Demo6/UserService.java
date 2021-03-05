package com.youngbald.oop.Demo6;

//接口都需要有个实现类
public interface UserService {
    //接口中定义的所有变量都是一个静态的常量
    //一般我们不去定义常量
    public static final int age = 99;
    //接口中的所有定义都是 abstract public
    void add(String name);
    void delete(String name);
    void update(String name);
    void query(String name);
}
