package com.youngbald.array;

import java.util.Arrays;

public class Demo7 {
    public static void main(String[] args) {
        //1. 2d array 11*11 0:nothing 1:black 2:white
        int[][] a1 = new int[11][11];
        a1[1][2] = 1;
        a1[2][3] =2;
        for (int[] ints : a1) {
            for (int anInt : ints) {
                System.out.print(anInt+"\t");
            }

            System.out.println();
        }

        //转换稀疏数组
        //获取有效值的个数
        int sum = 0;
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if(a1[i][j]!=0){
                    sum++;
                }
            }
        }
        System.out.println("有效值的个数为： "+sum);
        //2. 创建稀疏数组的数组
        int[][] a2 = new int[sum+1][3];
        a2[0][0]=11;
        a2[0][1]= 11;
        a2[0][2]= sum;
        //遍历二维数组，将非零的值，存放稀疏数组中
        int count=0;
        for (int i = 0; i < a1.length; i++) {
            for (int j = 0; j < a1[1].length; j++) {
                if(a1[i][j]!=0){
                    count++;
                    a2[count][0]=i;
                    a2[count][1]=j;
                    a2[count][2]=a1[i][j];

                }
            }

        }


        System.out.println("稀疏数组： ");
        for (int i = 0; i < a2.length; i++) {
            System.out.println(a2[i][0]+"\t"
                    +a2[i][1]+"\t"
                    +a2[i][2]+"\t");
        }

        System.out.println("======================");
        System.out.println("还原");
        int [][] a3 = new int[a2[0][0]][a2[0][1]];

//        for (int i = 0; i < n; i++) {
//            Arrays.fill(a3[i],0);
//        }
        for (int i = 1; i < a2.length; i++) {
            a3[a2[i][0]][a2[i][1]] = a2[i][2];
        }


        //print
        for (int[] ints : a3) {
            for (int anInt : ints) {
                System.out.print(anInt+"\t");
            }
            System.out.println();
        }

    }
}
