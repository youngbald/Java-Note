package com.youngbald.array;

import java.util.Arrays;

public class Demo6 {
    public static void main(String[] args) {

        int[] a = {53,2,2,4,1,2,4,5,200};
        sort(a);
        System.out.println(Arrays.toString(a));
    }


    //比较两个响铃的元素，第一个比第二个数大， 交换他们的位置
    //每一次比较都会产生一个最大或者最小的数字
    //下一轮可以少一次排序
    //一次循环，知道结束
    public static void sort(int[]a){
        int n = a.length;
        int temp = 0;
        //outer loop
        boolean flag = false;
        for (int i = 0; i < n-1; i++) {
            //inner loop
            for (int j = 0; j < n-1; j++) {
                if(a[j+1]<a[j]){//从小到大
                    //if（a[j+1]>a[j]） 从大到校swap
                    temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                    flag =true;
                }
            }
            if(!flag){
                break;
            }
        }
    }


}
