package com.youngbald.lambda;

public class TestLambda2 {

    public static void main(String[] args) {
//      1.lambda表示简化
        Ilove love= (int a )->{

                System.out.println("I love you-->"+a );

        };

        love.love(1);


//        简化1.参数类型
        love  = (a)->{

            System.out.println("I love you-->"+a );

        };
        love.love(2);


//        简化2.简化括号
        love = a->{
            System.out.println("i love you-->"+a );
        };
        love.love(3);

//        简化3去掉花括号
        love = a-> System.out.println("i love you -->"+a);
        love.love(4);


    }
}

interface Ilove{
    void love(int a);
}

