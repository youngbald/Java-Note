package com.youngbald.oop.Demo5;

public abstract class Action {

    public abstract void dosomething();

    public Action() {
    }
}

//抽象类不能被new出来，只能子类去实现他
//抽象类可以写普通方法
//抽象方法只能写在抽象类里
//存在的意义就是为了提高开发效率