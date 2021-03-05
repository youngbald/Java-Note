package com.youngbald.oop.Demo1;

//类 private：私有
public class Student {
//属性私有

    private String name;
    private int id;
    private char sex;
    private int age;

    //提供一些可以操作这个属性的方法
    //public get:获得属性 /set
    //get 获得这个数据
    public String getName(){
        return this.name;
    }
//set a value to this varaible
    public void setName(String name){
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if(age>120||age<0) {
           this.age = 3;
        }else
        {
            this.age = age;

        }
    }
}

