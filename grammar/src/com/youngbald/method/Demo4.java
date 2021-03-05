package com.youngbald.method;

public class Demo4 {
    public static void main(String[] args) {

        printMax(23,123,4,2,1231,34,1);//或者数字们
        printMax(new double[]{1,2,3,4,2,1,199});//可以传一个array进去
    }

    public static void printMax(double... numbers){
        if(numbers.length==0){
            System.out.println("no arg passed");
            return;
        }
        double result = numbers[0];
        for (int i = 0; i < numbers.length; i++) {
            if(numbers[i]>result){
                result=numbers[i];
            }
        }
        System.out.println("max value is "+ result);
    }
    public void test(int... i){
        System.out.println(i[0]);
        System.out.println(i[1]);
        System.out.println(i[2]);


    }

}
