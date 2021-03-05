package com.youngbald.oop.Demo1;

public class Pet {
    String name;
    int age;
    public void shout(){
        System.out.println("Meow");
    }

    public Pet(String name, int age) {
        this.name = name;
        System.out.println("name is "+name);
        this.age = age;
        System.out.println("ahe is "+age);
    }
}
