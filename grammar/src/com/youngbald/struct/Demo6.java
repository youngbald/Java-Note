package com.youngbald.struct;

public class Demo6 {
    public static void main(String[] args) {
        int sum1 = 0;
        int sum2= 0;

        for(int i = 0;i<=100;i++){
            if(i%2==1){
                sum1 = sum1+i;
            }else{
                sum2 = sum2+i;
            }

        }
        System.out.println("奇数之和： "+sum1);
        System.out.println("偶数之和： "+sum2);
        int count = 1;


        System.out.println("能被5整除，每行输出3个：");
        while(count<=1000){

                if (count % 5 == 0) {
                    System.out.print(count);
                    System.out.print(" ");
                    if(count%3==0){
                        System.out.println();
                    }

                }

                count++;

        }
        System.out.println();
        System.out.println();


        System.out.println("九九乘法表");
        int num = 1;
        int sum3 = 0;
        for(int i = 1;i<=9;i++){
           // System.out.print(i+"");
            for(int j = 1;j<=9;j++){

                System.out.print(i*j+"\t");
            }
            System.out.println();
        }



    }
}
