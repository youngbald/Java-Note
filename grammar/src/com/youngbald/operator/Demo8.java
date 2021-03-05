package com.youngbald.operator;


public class Demo8 {
    public static void main(String[] args) {
        //x? y :z
        //if x == true  result ->y else result ->z
        int score =50;
        String type = score<60 ?"不及格":"及格"; //必须掌握
        System.out.println(type);

    }
}
