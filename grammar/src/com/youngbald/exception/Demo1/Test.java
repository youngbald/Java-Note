package com.youngbald.exception.Demo1;

public class Test {
    //可能会存在异常的方法
    static void test(int a )throws MyException {
        if (a > 10) {

            throw new MyException(a);

        }
        System.out.println("ok");

    }

    public static void main(String[] args) {
        try{
            test(11);

        }catch (MyException e){
            System.out.println("my exception"+e);
        }
    }
}
