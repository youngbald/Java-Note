

# JAVA基础



## JAVA性能

 	1. 面向对象： 把重点放在面向对象跟对象的接口上
 	
 	2. 可移植性：跨平台性，不管操作系统 write once, run everywhere
 	3. 高性能：即时编译，效率比c++稍微低
 	4. 分布式：从本地打开url
 	5. 动态性：反射机制
 	6. 多线程：更好的交互行为，边打游戏边聊天
 	7. 安全性：防病毒之类的，很难造成计算机崩溃，异常机制

**JVM：虚拟机实现跨平台**

- javase：标准版（小游戏
- javame：已死
- javaee：e企业级开发，网站，服务器开发



**JDK JRE JVM** 

- JDK： java development kit 开发者工具 jdk包含了jre
- JRE: java runtime environment 包含虚拟机 applet
- JVM: java virtual machine

编写代码：

`public class Hello{`
	`public static void main(String[] args){`
		`System.out.print("Hello, World!");`
	`}`
`}`



## 编译

javac 文件名.java
运行
Java 文件名直接运行

大小写敏感
尽量使用英文

## java程序运行机制

- 编译型：计算机可以执行的代码，负责编译的机器叫做编译器
  操作系统： c/c++
- 解释型：及时翻译
  网页：对速度要求不高，java，js

java 同时拥有两种机制

- 编译
- 解释

程序运行机制
从java文件编译到class文件（字节码）
==>然后字节码文件运行 ==>进入类装载器==>字节码校验器==>解释器==>操作系统平台

先编译然后运用的过程

IDE 集成开发环境
具备了编辑器，编译器，调试之类的功能

I

在idea里

1. Public static void main ==>psvm自动补充
2. system.out.prin==> sout 自动补充
3. 每次创建就创建class

## 注释

单行注释 // 内容
多行注释 /* 内容*/
文档注释 /** 
			``* @description`
			`* @author` 
			`*`
			*内容*/`

**建议不要在编译器用中文，文件名也不可以中文**
**会出现编译不成功的情况**
**class undefined 之类**



## 标识符

关键字

类名
方法名
变量名 都需要标识符
所有的命名应该以字母开头命名$_A-Z

## 数据类型

强类型语言
要求变量的使用要求严格符合规定，所有变量都必须先定义才能使用
java c++
安全性高，速度慢

弱类型语言
js vb

变量赋值

```
type varName [=value] [{},varName =[=value]];
```

可以用逗号隔开来声明多个同类型变量

可以用逗号隔开来声明多个同类型变量

基本类型 primitive type

1. 数值类型  

   a.整数类型 byte 1（<127）, short 2, int 4, long 8

   b.浮点类型 float 4, double 8

   c.字符类型 char 2

   

2. Boolean类型：占1位只有true和false两个

引用类型 reference type

​	1.类

​	2.接口

​	3.数组



数值类型：

```java
public class HelloWorld {
    public static void main(String[] args) {
        //八大基本数据类型
        
        //整数
        int num1=10;
        byte num2 =20;
        short num3 =30;
        long num4 = 30L; //long后面加L
        
        //小数：浮点数
        float num5 = 50.1F;//float后面加F
        double num6 = 3.1421412412341241;
        
        //char 
        char name = 'a';
        //String 不是关键字， 是类
        String namea = "sajdhajsd";
        
        //bool
        boolean flag = true;
        boolean nflag =false;
    }
}

```

**int最大值 2^31 -1**

**int min -2^31 -1**

### 字节

1. 位 bit：是计算机内部存储的最小单位。 11001100是一个八位二进制数
2. 字节 byte 数据处理的基本单位 用大写B来表示
3. 1B = 8bit 位
4. 字符： 是指计算机中使用的字母，数字，字和符号



- 1bit表示1位
- 1Byte表示一个字节 1B= 8b
- 1024b = 1kb
- 1024M =1G

电脑的寻址能力跟32位或者64位直接挂钩

64位可以支持128G

32位只能支持4G



### 数据类型相关面试题

```java
import com.sun.javaws.IconUtil;

public class HelloWorld {
    public static void main(String[] args) {
        //整数拓展 进制 二进制0b 八进制0 十进制 十六进制
        int i = 10;
        int i2 = 010; //八进制0
        int i3 = 0x10;//十六进制0x 0~9 A~F 16
        System.out.println(i);
        System.out.println(i2);
        System.out.println(i3);
        System.out.println("===========================");
        //====================================================
        //浮点数拓展 银行业务怎么表示 ？钱
        //BigDecimal 数学工具类
        //=====================================================
        //float limited 有限 离散 舍入误差 大约 接近但不等于
        //double
        //最好完全使用浮点数进行比较
        float f = 0.1f; //0.1
        double d = 1.0/10; //0.1
        System.out.println(f==d);
        System.out.println(f);
        System.out.println(d);

        float d1 = 123124141223213f;
        float d2 = d1+1;
        System.out.println(d1==d2);//true
    //字符拓展
        //============================================
        char c1 = 'a';
        char c2 = '中';
        System.out.println(c1);
        System.out.println((int)c1);//强制转换
        System.out.println(c2);
        System.out.println((int) c2);//强制转换
        //所有的字符本质还是数字
        //编码 Unicode 2字节 0~65536 Excel 2^16 = 65536
        //U0000 UFFFF

        char c3 = '\u0061';
        System.out.println(c3);//a

        //转义字符
        //\t tab \n next line
        System.out.println("hello \t  \n world");


        System.out.println("==============================");

        String sa = new String( "hello world");
        String sb=  new String("hello world");

        System.out.println(sa==sb);

        String sc ="hello world";
        String sd ="hello world";
        System.out.println(sc==sd);
        //对象 从内存分析
        
        //boolean 
        boolean flag =true;
        if(flag){
        }

    }
}

```



## 类型转换

**java为强类型语言。有些运算需要用到类型转换**

运算中不同类型的数据ixan转化为同一类型，然后进行运算

`低------------------------------------->高`

`byte,short,char-> int-> long->float->double`

- 强制类型转换
- 自动类型转换

注意点：

1. 不能对布尔值进行转换

2. 不能把对象类型转换成不相干的类型

3. 再把高容量转换到低容量的时候强制转换

4. 转换时候可以存在内存溢出，或者精度问题

   ```java
   import com.sun.javaws.IconUtil;
   
   public class HelloWorld {
       public static void main(String[] args) {
          int i =128;
          byte b = (byte)i; //内存溢出 <127
           //强制转换  (类型)变量名 高->低
           double c = i;
   //        自动转换 低--高
           System.out.println(i);
           System.out.println(b);
           System.out.println(c);
   //
           System.out.println("==============");
           System.out.println((int) 23.7);
           System.out.println((int) -45.2432);
           System.out.println("===============");
           char d = 'a';
           int f = d+1;
           System.out.println(f);
           System.out.println((char) f);
       }
   }
   
   ```



long类型转换

```java
import com.sun.javaws.IconUtil;

public class HelloWorld {
    public static void main(String[] args) {
       //操作比较大的数字，注意溢出问题
        //jdk7, 数字之间可以用下划线分割
        int money =10_0000_0000;
        int years =20;
        int total = money*years;//溢出了
        long total2 = money*years;//默认是int，转换之前已经存在问题了
        long total3 = years*(long)money;//先把一个数转换为long
        System.out.println(total);
        System.out.println(total2);
        System.out.println(total3);
        
    }
}

```







## 变量

- 变量是可以变化的量
- java是一种强类型语言，每个变量都必须声明其类型
- java变量是程序中最基本的存储单元，其要素包括变量名，变量类型和作用域

```java
type varName [=value ] [{,varName[=value]}]

```



- 每个变量都有类型，类型可以是基本类型也可以是引用类型
- 变量名必须是合法的标识符
- 变量生命是一条完整的语句，因为必须以一个分号结束



变量作用域

- 类变量 static
- 实例变量 从属于对象，通过类去使用他
- 局部变量 必须声明和初始化值



常量

常量（constant）：初始化之后不能再改变值， 不会变动的值

所谓常量可以理解成一种特殊的变量，他的值被设定后，再程序运行过程中不允许被改变

```java
final 常量名 = 值；
final double PI = 3.14；
```

一般使用大写字符

```java
//修饰符不存在先后顺序
public static final double PI = 3.14;

```



### 变量的命名规范

1. 所有变量、方法、类名：见名知意
2. 类成员变量：首字母小写和驼峰原则：monthSalary
3. 局部变量：首字母小写和托更原则
4. 常量：大写字母和下划线：MAX_VALUE
5. 方法名：首字母小写和驼峰原则： run(), runRun()
6. 类名：首字母大写Hello

```java
public class Demo2 {


    //类百年来 static
    static double salary = 2500;

    //属性：变量
    //实例变量:从属于对象：通过这个类去使用他
    //不自动初始化，就会变成默认值 0 0.0
    //boolean = false
    //除了基本类型，其余的默认都是null
    String name;
    int age;

    //main
    public static void main(String[] args) {
        //局部变量：必须声明和初始化值
        int i = 10;

        //变量类型：变量名字 = new Demo2();
        Demo2 demo2 = new Demo2();
        System.out.println(demo2.age);
        System.out.println(demo2.name);


        System.out.println(salary);


        //类变量 static
    }

    //其他method
    public void add(){

    }
}

```



## 运算符

- 算数运算符 + - * / % ++ --
- 赋值运算符 =
- 关系运算符 > < >= <= == !=
- 逻辑运算符 && || !
- 位运算符 &, |,^, ~,>>,<<,>>> 计算机操作
- 条件运算符 ? : 偷懒
- 拓展赋值运算符 += -= *= /= 偷懒



### 算数运算符

```java
package operator;

public class Demo1 {
    public static void main(String[] args) {
        //二元运算符
        //ctrl +d 赋值当前行到下一行

        int a =10;
        int b =20;
        int c =25;
        int d =25;
        System.out.println(a+b);
        System.out.println(a-b);
        System.out.println(a/(double)b);
        System.out.println(a*b);
    }
}

```



### 赋值运算符

```java
package operator;

public class Demo2 {

    public static void main(String[] args) {
        long a =23817284712L;
        int b =123;
        short c=10;
        byte d=8;
        System.out.println(a+b+c+d); //long
        System.out.println(b+c+d);//int
        System.out.println((double)(c+d));//int
    }

//有代码优先级情况，如果最高级位存在，不同类型的数字会转换成最高级的类型
//如果有操作数不是 int，它会先被以数值升级宽化到 int 型别
//需要手动转回去

}

```

### 关系运算符

```java
package operator;

public class Demo3 {
    public static void main(String[] args) {
        //关系运算符返回的结果 正确、错误 只有布尔值
        int a =10;
        int b = 20;
        System.out.println(a>b); //f
        System.out.println(a<b);//t
        System.out.println(a==b);//f
        System.out.println(a!=b);//t
    }
}

```



### ++ -- 运算符跟幂运算

```java
package operator;

public class Demo4 {
    public static void main(String[] args) {
        //++ -- 自增自减，一元运算符
        int a  =3;
        int b = a++;//after this line of code, assign b to 3 then a = a+1
        //a = a+1;
        System.out.println(a);
        //a+ a= a+1;
        int c = ++a;//before this line of code, a = a+1,
        // then assign the value to c
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);


        //幂运算 2^3 很多其他运算使用工具来操作
       double pow = Math.pow(3,2);
        System.out.println(pow);
    }
}

```



### 逻辑运算符

```java
package operator;

public class Demo5 {
    public static void main(String[] args) {
        //逻辑运算符
        //与或非
        boolean a  = true;
        boolean b =false;
        System.out.println("a&&b:" +(a&&b));
        System.out.println("a||b:"+(a||b));
        System.out.println("!(a&&b):"+!(a&&b));

        //短路运算
        //错了只会运行前半部分 &&后面不运行
        int c =5;
        boolean d = (c<4)&&(c++<4);
        System.out.println(d);//false
        System.out.println(c);//5
    }
}

```





### 位运算

```java
package operator;

public class Demo6 {
    public static void main(String[] args) {
        /*
        A = 0011 1100
        B = 0000 1111

        A&B = 0000 1100
        A|B = 0011 1101
        A^B =0011 0001   抑或
        ~B = 1111 0000 取反
        
        位运算效率极高
        
        2*3 = 16  2*2*2*2
        左移 <<*2  
        >>右移 /
        
        0000 0000       0
        0000 0001       1
        0000 0010       2
        0000 0011       3
        
         */
        System.out.println(2<<3);//16
    }
}

```

扩展赋值运算符

```java
package operator;

public class Demo7 {
    public static void main(String[] args) {
        int a  = 10;
        int b = 20;
        a+=b; //a = a+b
        a-=b; //a = a-b
        System.out.println(a);
        //字符串连接符 + String
        System.out.println(a+b);
        //结果会变成String
        System.out.println(""+a+b);
        //加放在字符串前面不会被影响
        System.out.println(a+b +"");
    }
}

```



### 三元运算符

```java
package operator;

public class Demo8 {
    public static void main(String[] args) {
        //x? y :z
        //if x == true  result ->y else result ->z
        int score =50;
        String type = score<60 ?"不及格":"及格"; //必须掌握
        System.out.println(type);
    }
}

```



**最后**

**优先级使用（）**





## 包机制

- 为了更好的组织类，java提供了包机制，用于区别类名的命名空间。

- 包语句的语法格式为：

  ```java
  package pkg1[. pkg2[. pkg3...]];
  ```

- 一般利用公司域名倒置作为包名；www.baidu.com ==>com.baidu.www 

  

- 为了能够使用某一个包的成员，我们需要再java程序中明确导入该包。使用Import 语句可以完成此功能

  

  ```java
  import package1[.package2..].(classname|*);
  ```

  

create package ==>

com.youngbald.xxx

导入这个包里的所有的类

```
import com.youngbald.base.*;
```



## JavaDoc

- javadoc 命令是用来生成自己api文档的

- 参数信息

1.  @author作者名
2. @version 版本号
3. @since 指明需要最早使用的jdk版本
4. @param 参数名
5. @return 返回值情况
6. @throws 异常抛出情况

加载类上就是类的注释

加载method就是method是注释

![image-20210224002611059](C:\Users\linyi\AppData\Roaming\Typora\typora-user-images\image-20210224002611059.png)

javadoc name.java

or

javadoc UTF-8 -charset UTF-8 name.java



## Java流程控制

1. 1. 用户交互结构Scanner

   2. 顺序结构

   3. 选择结构

   4. 循环结构

   5. break & continue

   6. 联系

      



### 用户交互Scanner

java.util.Scanner 是java5的特征

通过Scanner类获取用户的输入

基本语法

```java
Scanner s = new Scanner(System.in);
```

通过Scanner类的next（）与nextLin（）方法获取输入的字符串，在读取钱我们使用hasNext() & hasNextLin()判断是否还有输入的数据

```java
package com.youngbald.scanner;

import java.util.Scanner;

public class Demo1 {
    public static void main(String[] args) {
        //创建一个扫描器对象，用于接受键盘数据
        Scanner scanner = new Scanner(System.in);

        System.out.println("使用next方式接收：");
        //判断用户有没有输入字符串
        if(scanner.hasNextLine()){
            //使用next方式接收 下一行
            
            String str = scanner.nextLine();
            
            System.out.println("输出的内容为：" +str);
        }
        //凡是属于IO流的类如果不关闭会一直占用资源，用完就要关掉
        scanner.close();
    }
}
```



next()

- 读取到有效字符后才可以结束输入
- 对输入有效字符之前遇到的空白，next()方法会自动将其去掉
- 只有输入有效字符后才将其输入的空白作为分隔符或者结束符
- next()不能得到带有空格的字符串

nextLin():

- 以enter为结束符 nextline 方法返回的是输入回车之前的所有字符。
- 可以获得空白



```java
package com.youngbald.scanner;

import java.util.Scanner;

public class Demo3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = 0;
        double sum = 0;
        System.out.println("please enter a number");
        while(scanner.hasNextDouble()){
            System.out.println("please enter a number ");
            count++;
            sum = sum+ scanner.nextDouble();

        }
        System.out.println("the average of your inputs is :");
        System.out.println(sum/count);

        scanner.close();
    }
}
```





### 顺序结构

- JAVA的基本结构就是顺序结构，除非特别指明， 否则就按照顺序一句一句执行
- 顺序结构是最简单的算法结构
- 语句与语句之间，框与框之间是按从上到下的顺序进行的，它是由脱肛额一次执行的处理步骤组成的，它是任何一个算法都离不开的一种基本算法结构。



### if选择结构

if单选结构

```java
package com.youngbald.struct;

import java.util.Scanner;

public class Demo1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入：");
        String s = scanner.nextLine();

        //equals 用来判断字符串是否相等
        if(s.equals("Hello")){
            System.out.println(s);
        }else{
            System.out.println("World");
        }

        scanner.close();
    }
}
```

if双选择结构

```java
package com.youngbald.struct;

import java.util.Scanner;

public class Demo2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("输入成绩：");
        int score = scanner.nextInt();
        if(score>60){
            System.out.println("及格");
        }else{
            System.out.println("不及格");
        }
        scanner.close();
    }
}
```

if多选择结构

```java
if()
else if()
else if()
else()
```



### switch多选择结构

- 多选择结构还由一个实现方式就是switch case语句
- switch case 语句判断一个变量与一系列值中某个值是否相等，每个值称为一个分支
- swicth 语句中的变量类型可以是
  1. byte,short,int, char
  2. **从java se 7开始 switch 支持字符串String类型**
  3. 同时case标签必须为字符串常量或者字面量

```java
package com.youngbald.struct;

import java.util.Scanner;

public class Demo3 {
    public static void main(String[] args) {
        char grade  = 'A';
        switch (grade){
            case 'A':
                System.out.println("优秀");
                break;
                //一定需要break不然会继续运行下面的代码
            case 'B':
                System.out.println("良好");
                break;
            default:
                System.out.println("菜鸡！");
                //default 似乎不需要break

        }
    }
}
```



### 循环结构

- while循环
- do....while 循环
- for 循环

在java5 中引入了一种主要用于数组的增强型for循环

- while是最基本的循环，结构为

  ```java
  while(condition){
  //loop
  }
  ```

- 只要bool is true， while loop keeps going

- 我们大多数情况是会让循环停止下来的，需要一个让表达式失效的方式来结束循环

- 少部分情况需要循环一直执行，比如服务器的请求响应监听等

- 循环条件一直为true会造成死循环。尽量避免死循环。会影响程序性能或者造成循序卡死奔溃

  ```java
  package com.youngbald.struct;
  
  public class demo4 {
      public static void main(String[] args) {
          int count = 1;
          int sum = 0;
          while(count<=100){
  
              sum = sum+count;
             // System.out.println(sum);
              count++;
  
          }
          System.out.println(sum);
  
      }
  }
  ```



do.. while 循环

- 对于while语句而言，如果不满足条件，则不能进入循环。但有时候我们需要即使不满足条件也至少执行一次。

- do..while 循环和while循环相似，不同的是，do while会至少执行一次

  ```java
  do{
  //something first
  }
  while(condition);
  ```

- while 和do while的区别：

  1. while先判断后执行。dowhile是先执行后判断

  2. dowhile 总是保证循环体会执行至少一次

     ```java
     package com.youngbald.struct;
     
     public class Demo5 {
         public static void main(String[] args) {
             int  i =0;
             int sum = 0;
             do{
                 sum+=i;
                 i++;
             }while(i<=100);
             System.out.println(sum);
         }
     }
     ```



### for循环

- for循环语句是支持迭代的一种通用结构，是最有效、最灵活的循环结构。

- for循环执行的次数是在执行前就确定的。语法格式：

  ```java
  for(int  i = 0;i<num;i++){
  //do something
  }
  ```

IDEA快捷键

num.for 会自动生成for loop

其中需要注意的是第一个condition可以为空



//死循环

for(; ; ;)

```java
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
        int count = 0;


        System.out.println("能被5整除，每行输出3个：");
        while(count<=1000){

                if (count % 5 == 0&&count!=0) {
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

            for(int j = i;j<=9;j++){

                System.out.print(i*j+" ");
            }
            System.out.println();
        }

        

    }
}

```

九九乘法表：

```java
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


```



### 增强forloop

- java5 引入了一种主要用于数组或集合的增强型forloop

  ```java
  for（声明语句：表达式）{
  //代码
  }
  ```

- 声明语句：声明新的局部变量，该变量的类型必须和数组元素的类型匹配。其作用域限定在循环语句块，其值与此时数组元素的值相等

- 表达式：表达式是要访问的数组名，或者是返回值为数组的方法



```java
package com.youngbald.struct;

public class Demo7 {
    public static void main(String[] args) {
        int [] num = {10,20,30,40,50};//定义一个数组
        for(int x:num){
            System.out.println(x);
        }
    }
}
```

```java
//equavelent to
for (int i = 0; i < num.length; i++) {
    System.out.println(num[i]);
}
```



### break continue

- break在任何循环语句的主题部分，均可用break控制循环的流程。**break用于强行退出循环**，不执行循环中剩余的语句。（也在switch中使用）
- continue'**用于中止某次循环过程**，跳过循环体中尚未执行的语句，接着进行下一次是否执行循环的判定



goto关键字

- 带标签的break和continue
- “标签”指的是后面跟一个冒号的标识符 ： label:
- 唯一用到标签的地方是在循环语句之前。使用理由是：我们希望在其中嵌套另一个循环，由于break和continue通常只终端当前循环，但若随同标签使用，他们就会终端到存在标签的地方

```java
package com.youngbald.struct;

public class Demo8 {
    public static void main(String[] args) {
       //101-150 prime num
        int count=  0;
        outer:for (int i = 101; i < 150; i++) {
            for(int j = 2;j<i/2;j++){
                if(i%j==0){
                    continue outer;
                }
            }
            System.out.print(i+" ");
        }
    }
}
```



### 打印三角形

```java
package com.youngbald.struct;

public class Demo9 {
    public static void main(String[] args) {
        //造个倒三角


        for (int i = 1; i <= 5; i++) {
            for(int j = 5;j>=i;j--){
                System.out.print(" ");
            }
            for(int j = 1; j<=i; j++){
                System.out.print("*");
            }
            for(int j = 1;j<i;j++){
                System.out.print("*");
            }

            System.out.println();
        }

    }


}
```





## Java方法详解

method(1,2);

1. 什么是方法？
2. 方法的定义以及调用
3. 方法重载
4. 命令行传参
5. 可变参数
6. 递归



方法是什么？

- Systen.out.println() ==>类.对象.方法
- Java方法是语句的集合，他们在一起执行一个功能
  1. 方法是解决一类问题的步骤的有序组合
  2. 方法包含于类或对象中
  3. 方法在程序中被创建，在其他地方被引用

设计方法的原则：方法的的本意是功能块，就是实现某个功能的语句块的集合，我们设计方法的时候最好保持方法发原子性，就是一个方法只完成一个功能，这样利于我们后期的扩展

```java
package com.youngbald.method;

public class Demo1 {
    public static void main(String[] args) {
        int a  = add(1,2);
        System.out.println(a);
    }

    //加法
    public static int add ( int a, int b){
        return a+b;
    }
}
```

**加入static 变成类变量**

### 方法的定义



- 方法包含一个方法投和一个方法体

1. 修饰符是可选的，告诉编译器如何调用该方法
2. 返回值类型：void，int double boolean
3. 方法名
4. 参数类型：也可以不包含任何参数，实参和或者比哪里那个。
5. 方法体：包含具体的语句，定义该方法的功能



```
修饰符 返回值类型 方法名（参数类型 参数名）{

……

方法体

……

}


```



比大小方法

```java
package com.youngbald.method;

public class Demo2 {
    public static void main(String[] args) {
        int a = max(2,3);
        System.out.println(a);

    }

    public static int max(int a, int b){
       return  a>b? a:b;
    }

}
```



值传递：pass by value 

```java
public static void main(String[] args) {
    ParamTest pt = new ParamTest();
 
    int i = 10;
    pt.pass(i );
    System.out.println("print in main , i is " + i);
}
 
public void pass(int j) {
    j = 20;
    System.out.println("print in pass , j is " + j);

```

in pass: i = 20;

in main i = 10;

-->java的方法中，在传递普通类型的时候是值传递



引用传递：pass by reference

```java

public static void main(String[] args) {
    ParamTest pt = new ParamTest();
 
    User hollis = new User();
    hollis.setName("Hollis");
    hollis.setGender("Male");
    pt.pass(hollis);
    System.out.println("print in main , user is " + hollis);
}
 
public void pass(User user) {
    user.setName("hollischuang");
    System.out.println("print in pass , user is " + user);

```

output will be the same both in main and pass

-->在传递对象类型的时候是引用传递

值传递（pass by value）是指在调用函数时将实际参数复制一份传递到函数中，这样在函数中如果对参数进行修改，将不会影响到实际参数。

引用传递（pass by reference）是指在调用函数时将实际参数的**地址**直接传递到函数中，那么在函数中对参数所进行的修改，将影响到实际参数。





### 方法的重载

重载就是在一个类中，由相同的函数名称，但形参不同的函数

方法的重载的规则：

1. 方法名称必须相同。
2. 参数列表必须不同（个数，类型，参数牌系列顺序不同）
3. 方法的返回类型可以相同也可以不相同
4. 仅仅发挥类型不同不足以称为方法的重载

实现理论：

方法名称相同时，编译器会根据调用方法的参数个数、参数类型等去逐个匹配，以选择对应的方法，如果匹配失败，则编译器报错。

**方法可以无限多重名**

```java
package com.youngbald.method;

public class Demo2 {
    public static void main(String[] args) {
        int a = max(100,100);
        double b  =max(10.2,130.2);
        System.out.println(a);
        System.out.println(b);

    }

    public static int max(int a, int b){
        if(a==b){
            System.out.println("they are equal");
            return 0; //中止方法
        }
       return  a>b? a:b;
    }
    public static double max(double a, double b){
        if(a==b){
            System.out.println("they are equal");
            return 0; //中止方法
        }
        return  a>b? a:b;
    }
    public static int add(int a , int b ,int c){
        return a+b+c;
    }

}

```





### 命令行传参

有时候你希望运行一个程序时候再传递给它消息。这要靠传递命令行参数给main（）函数实现

```java
package com.youngbald.method;

public class Demo3 {
    public static void main(String[] args) {
        for (int i = 0; i < args.length; i++) {
            System.out.println("args["+i+"]: "+args[i]);
        }
    }

}
```

<img src="C:\Users\linyi\AppData\Roaming\Typora\typora-user-images\image-20210225164232909.png" alt="image-20210225164232909" style="zoom:150%;" />



### 可变参数

- JDK1.5 开始，java支持传递同类型的可变参数给一个方法
- 在方法声明中，在指定参数类型后加一个省略号（……）；
- 一个方法中只能指定一个可变参数，他必须是方法的最后一个参数，任何普通的参数必须在他之前声明



```java
package com.youngbald.method;

public class Demo4 {
    public static void main(String[] args) {

        printMax(23,123,4,2,1231,34,1);//或者数字们
        printMax(new double[]{1,2,3,4,2,1,199});//可以传一个array进去
    }

    public static void printMax(double... numbers){
        if(numbers.length==0){
            System.out.println("no arg passed");
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
```





### 递归

- A方法调用B方法
- 递归就是：A方法调用A方法，自己调用自己
- 利用递归可以用简单的程序来解决一些复杂的问题。他通常把一个大型复杂的问题层层转化为一个与原问题相似的规模较小的问题来求解，递归册罗只虚少量的程序就可以描述出解题过程所需要的多次重复计算，大大减少了程序的代码量，递归的能力在于用有限的语句来定义对象的无限集合
- 递归包概括两个部分
  - 递归头：什么时候不调用自身方法。如果没有头，将陷入死循环。
  - 递归体：什么时候需要调用自身方法

边界条件：break conditon 

前阶段：

返回阶段：n*(n-1)

用递归是计算小的情况下

```java
package com.youngbald.method;

public class Demo5 {
    public static void main(String[] args) {
        int a = f(5);
        System.out.println(a);
    }

    public static int f (int a){
        if(a==1) return 1;
        else{
            return a*f(a-1);
        }


    }
}
```

不太完善的计算器：

```java
package com.youngbald.method;

import java.util.Scanner;

public class calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter your operation as +-*/");
        char a = scanner.next().charAt(0);
        double res = 0.0;

        System.out.println("enter numb1, quit with 'q'");

        while (scanner.hasNextDouble()) {
            double num1 = scanner.nextDouble();
            System.out.println("enter numb2");

            double num2 = scanner.nextDouble();

            switch (a) {
                case '+':
                    res = add(num1, num2);
                    break;
                case '-':
                    res = minus(num1, num2);
                    break;
                case '*':
                    res = times(num1, num2);
                    break;
                case '/':
                    res = over(num1, num2);
                    break;
                default:
                    res = 0;
                    System.out.println("operation is invalid!");
            }
            System.out.println("your result is: " + res);

        }
    }


    public static double add(double a, double b){
        return a+b;
    }
    public static double minus(double a, double b){
        return a-b;
    }
    public static double times(double a, double b){
        return a*b;
    }
    public static double over(double a, double b){
        return a/b;
    }


    }
```







## 数组

1. 数组概述
2. 数组声明创建
3. 数组使用
4. 多为数组
5. arrays类
6. 稀疏数组



### 数组的定义

- 数组是相同类型数据的有序集合
- 数组描述的是相同的类型的若干个数据，按照一定的先后次序排列组合而成
- 其中，每一个数据乘坐一个数组元素，每个数组元素可以通过一个下标来访问他们



### 数组声明创建

- 首先必须声明数组变量，才能在程序中使用数组。

  语法：

```java
dataType[] arrayRefVar; //recommend
//
dataType arrayRefVar[];
```

- java语言使用new操作符来创建数组，语法：

  ```java
  dataType[] arrayRefVar = new fataType[arraySize];
  ```

- 数组的元素是通过索引访问的，数组索引从0开始

- 获取数组长度: array.length

### 数组的四个基本特点

- 长度是确定的，一旦被创建他的大小就是不可以改变的
- 其元素必须是相同类型，不允许出现混合类型
- 数组中的元素可以是任何数据类型，包括基本类型和引用类型
- 数据变量属于引用类型，数组也可以看成是对象，数组中的每个元素相当于该对象的成员变量
- 数组本身就是对象，java中对象是在堆中的，因此数组无论保存原始类型还是其他对象类型，数组对象本身是在堆中的



### 内存分析

堆：

- 存放new的对象和数组
- 可以被所有的线程共享，不会存档别的对象引用

栈：

- 存放基本变量类型（包含具体数值
- 引用对象的变量（包含引用在堆里的具体地址

方法区：

- 可以被所有的线程共享
- 包含了所有的class和static变量

![img](https://cdn.nlark.com/yuque/0/2020/png/1281683/1595057156211-a628a34c-4609-4df2-b0cc-ca7b48e414bd.png)

```java

package com.youngbald.array;

public class Demo2 {
    public static void main(String[] args) {
        //静态初始化,创建加赋值
        int [] a  ={1,2,3,4,5,6,7};
        System.out.println(a[0]);
        //引用类型
        Demo2[] demos = {new Demo2(),new Demo2()};
        
        //动态初始化:包含默认初始化 都是0
        int[] b = new int[10];
        b[0] =10;
        System.out.println(b[0]);
    }
}
```





### 数组边界

- 下表的合法区间：[0, length-1] 如果越界就会报错

  ```
  int[] a = new int[2];
  sout (a[2]) 报错
  ```

- arrayindexoutofboundexception：数组下标越界异常

- 小结

  - 数组是相同数据类型的有序集合
  - 数组也是对象，数组元素相当于对象的成员变量
  - 数组长度确定的不可变的，如果越界就会报错



### 数组使用

- for-each循环
- 数组作方法入参
- 数组作返回值

```java
package com.youngbald.array;

public class Demo3 {
    public static void main(String[] args) {
        int [] nums = {1,2,3,4,5};
        int sum = 0;

        //print sum of the array
        //没有下标
        for(int i:nums){
            sum+=i;
            System.out.println(i);
        }
        System.out.println(sum);
        //print max num in array
        int max = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if(max<nums[i]){
                max = nums[i];
            }
        }
        System.out.println(max);

        printArr(nums);

        int[] reverse = reverse(nums);
        printArr(reverse);

    }


    public static void printArr(int[] a){
        for (int i : a) {
            System.out.print(i+ " ");

        }
        System.out.println();

    }
    public static int[] reverse(int[] a){
        int n = a.length;
        int[]res = new int[n];
        for(int i = 0, j = res.length-1;i<n;i++,j--){
            res[j] = a[i];

        }
        return res;
    }
}
```



### 多维数组

- 多维数组可以堪称是数组的数组，比如二维数组就是一个特殊的一维数组，其每一个元素都是一个以为数组。

- 二维数组：

  ```java
  int a[][] = new int[2][5];
  ```

- 以上二位数组a可以堪称一个两行五列的数组

```java
package com.youngbald.array;

public class Demo4 {
    public static void main(String[] args) {
        //[3][2]
        int[][] a = {{1, 2}, {3, 4}, {5,6}};

        for (int i = 0; i < a.length; i++) {
            for (int i1 = 0; i1 < a[i].length; i1++) {
                System.out.print(a[i][i1]+" ");
            }
        }
    }


}
```



### array 类

- 数组的工具类 java.utl.Arrays
- 由于数组对象本身没有声明方法可以供我们调用，但API中提供了一个工具类Arrays供我们使用，从而可以堆数据对象进行一些基本的操作
- 查看jdk帮助文档
- arrays类中的方法都是static修饰的静态方法，在使用的时候可以直接使用类名进行调用，而“不用”使用对象来调用
- 具有一下常用功能：
  - 给数组赋值:通过fill方法
  - 对数组排序：sort，升序
  - 比较数组：equals比较元素是否相等
  - 查找数组元素：binarysearch 对排序好的数组进行二分查找法操作

```java
package com.youngbald.array;


import java.util.Arrays;

public class Demo5 {
    public static void main(String[] args) {
        int [] a = {1,2,4,213,43,5,2312,2,4566};
        System.out.println(a);//[I@1b6d3586

        //print
        System.out.println(Arrays.toString(a));
        //排序
        Arrays.sort(a);
        //print
        System.out.println(Arrays.toString(a));

        //fill 填充
        Arrays.fill(a,2,4,0);
        System.out.println(Arrays.toString(a));
        Arrays.fill(a,0);
        System.out.println(Arrays.toString(a));
    }


}
```



### 冒泡排序

- 两层循环，外层冒泡轮数，里层依次比较
- 时间复杂度O(n2)

```java
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
```



### 稀疏数组

- 需求：编写五子棋游戏中，有存盘退出和续上盘的功能

![img](https://cdn.nlark.com/yuque/0/2020/png/1281683/1595061493434-6a04e2a0-2239-491f-983a-dbd0df48b1b0.png)

- 分析问题：因为该二维数组的很多值是默认0，因此记录了很多没有意义的数据
- 解决：稀疏数组

稀疏数组介绍：

- 当一个数组中大部分元素为0，或者为同一值的数组时，可以使用稀疏数组来保存该数组。

- 处理方式：

  - 记录数组一共有几行几列，有多少个不同值

  - 把具有不同值的元素和行列及值记录在于个小规模的数组中，从而缩小程序的规模

    ![image.png](https://cdn.nlark.com/yuque/0/2020/png/1281683/1595063729685-a2778503-ef1c-4ed5-aabd-1b101a9ef63c.png?x-oss-process=image%2Fresize%2Cw_616)

```java
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
```



## 面向对象

java的核心思想就是OOP

- 初时面向对象
- 方法回顾和加深
- 对象的创建分析
- 面向对象的三大特效
- 抽象类和接口
- 内部类及OOP实战



### 面向过程&面向对象

- 面向过程思想 ：线性思维
  - 步骤清晰简单，第一步什么，第二步做什么
  - 面对过程适合处理一些较为简单的问题
- 面向对象思想
  - 物以类聚，**分类**的思维模式，思考问题首先会解决问题需要那些分类，然后对这些分类进行单独思考。最后，菜对某个分类下的细节进行面向过程的思索
  - 面向对象适合处理复杂的问题，适合处理需要多人协作的问题
- **对于描述复杂的事物，为了从宏观上把握、从整体上合理分析，我们需要使用面向对象的思路来分析整个系统。但是，具体到围观操作，仍然需要面向过程的思路去处理**

属性加方法就是一个类

### 什么是面向对象

- 面向对象编程（Obeject-oriented programming, OOP)
- 本质就是：以类的方式组织代码，以对象的组织（封装）数据
- 抽象
- 三大特性
  - 封装
  - 继承
  - 多态
- 从认识论角度考虑是现有对象后有类。对象是具体的事物。类是抽象的，是对对象的抽象。
- 从代码运行角度考虑是先有类后又对象。类是对象的模板



回顾方法及加深

- 方法的定义
  - 修饰符
  - 返回类型
  - break：跳出loop和return跳出function的区别
  - 方法名
  - 参数列表：参数类型，参数名
  - 参数列表异常抛出
- 方法的调用
  - 静态方法
  - 非静态方法
  - 形参和实参
  - 值传递和引用传递
  - this关键字



```java
package com.youngbald.oop;

import java.io.IOException;

//class 类
public class Demo1 {
    //main  function/method
    public static void main(String[] args) {

    }

    //修饰符， 返回值类型，方法名（）{}
    public String Hello(){
        return "hello world";
    }
    //
    public void hello(){
        System.out.println("hello");
        return;
    }
    //void return nothing
    public void print(){
        return;
    }
    //return int type
    public int man(int a, int b){
        return a>b?a:b;
    }
    
    //抛出异常
    public void readFile(String file) throws IOException{
        
    }

}
```





### 静态和非静态方法

```java
package com.youngbald.oop;

public class Demo2 {
    public static void main(String[] args) {
        //static
        //实例化 非静态化 method里没有static

        Student student = new Student();
        student.talk();


        //no static
    }
    //static 和类一起加载
    public static void a(){

    }
    //类实例化之后才存在
    public void b(){}

}
```





### 形参跟实参

```java
package com.youngbald.oop;

public class Demo3 {
    public static void main(String[] args) {
      int a =  new Demo3().add(1,2);
        System.out.println(a);
    }

    public int add(int a, int b){
        return a+b;
    }
}
```



### 值传递和引用传递

值传递：

```java
package com.youngbald.oop;

//值传递
public class Demo4 {
    public static void main(String[] args) {
        int a = 1;
        change(a);
        System.out.println(a);
    }

    public static void change(int a){
        a = 10;
    }
}
```



引用传递：

```java
package com.youngbald.oop;

//引用传递：对象，本质还是值传递
//对象，内存
public class Demo5 {
    public static void main(String[] args) {
        Person person = new Person();

        System.out.println(person.name); //null

        Demo5.change(person);
        System.out.println(person.name);
    }

    public  static  void change(Person person){
        //person 是一个对象，指向person这个类
        //所以是一个引用传递
        //可以改变属性
        person.name = "youngbald";
    }


}
//定义一个类，有一个属性：name
class Person{
    String name;
}
```





### 类与对象的关系

- 类是一种抽象的数据类型， 他是对某一类事物整体描述/定义，但是并不能代表某一个具体的事物。
  - 动物，植物，手机，电脑
  - Person类，pet类，car类等，这些类都是用来描述、定义某一类具体的事物应该剧本的特点和行为
- 对象是抽象概念的具体实例
  - 张三就是人的一个具体实例，张三家里的忘词啊就是勾搭一个具体实例
  - 能够体现出特点，展现出功能的是具体的实例，而不是一个抽象的概念

### 创建与初始化对象

- 使用new关键字创建对象
- 使用new关键字创建的适合，除了分配内存空间之外，还会给创建好的对象**进行默认的初始化**以及对类中构造器的调用
- 类中的构造器也称为构造方法，是进行创建对象的适合必须要调用的。并且构造器有一下俩特点：
  - 必须和类的名字相同
  - 必须没有返回类型，也不能写void



class code:

```java
package com.youngbald.oop;

//student class
public class Student {

    //属性：字段
    String name;//null
    int age;//0

    //method/function

    public void study(){
        System.out.println(this.name+" is studying.");
    }

}
```

```java
main:

package com.youngbald.oop;
//only one main in a project
public class Application {
    public static void main(String[] args) {
//class: abstract, actual
        //类实例化后会返回一个自己的对象
//        student对象就是一个student类的具体实例
        Student a = new Student();
        Student b = new Student();
        System.out.println(a.name);

    }
}
```



### 构造器

```java
package com.youngbald.oop;

//定义一个类，有一个属性：name
class Person{
    String name;
   //一个类啥也不写也会出现构造方法

    //无参数构造
    //1.使用new关键字。必须要有构造器
    //2.构造器用来初始化值
    public Person(){
        this.name = "bald";
    }

    //有参构造器
    public Person(String name){
        this.name = name;
    }
    
}
```

```java
package com.youngbald.oop;

//定义一个类，有一个属性：name
class Person{
    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    
    /*
    * 构造器
    * 1. 和类名相同
    * 2. 没有返回值
    * 作用：
    * 1.new 本质再调用构造方法
    * 2.初始化对象的值
    * 主义之：
    * 1.定义有构造之后，如果像使用无参构造，显示的定义一个无参的构造*
    /
    
    
}
```



在IDEA里创建constructor快捷键

**fn+ del+alt**

![img](https://cdn.nlark.com/yuque/0/2020/png/1281683/1595075783214-51f4d457-a6ef-498f-b394-0c9669c3067e.png)

//class

```java
package com.youngbald.oop;

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
```

//main

```java
package com.youngbald.oop;

public class Application {
    public static void main(String[] args) {
     Pet dog = new Pet("omi",2);

     dog.shout();
//        System.out.println(dog.name);
//        System.out.println(dog.age);
    }
}
```



### 小结

1. 类与对象
   - 类是一个模板：抽象，对象是一个具体的实例
2. 方法
   - 定义、调用
3. 对应的引用
   - 引用类型： 基本类型（8）
   - 对象是通过引用来操作的：栈-->堆
4. 属性：字段 field 成员变量
   - 默认初始化：
     - 数字：0 0.0
     - char： u0000
     - boolean: false
     - null
   - 修饰符 属性类型 属性名 = 属性值
5. 对象的创建和使用
   - 必须使用new 关键字创建对象，构造器Person person new Person（）；
   - 对象的属性 person.name
   - 对象的方法 person.sleep()
6. 类：
   - 静态的属性 属性
   - 动态的行为 行为



封装、继承、多态



## 面向对象三兄弟

### 封装 package

- 该露的露，该藏的藏
  - 我们程序设计要追求“高内聚，低耦合”。 高内聚就是类的内部数据操作细节自己完成，不允许外部干涉；低耦合“仅暴露少量的方法给外部使用。
- 封装（数据的隐藏）
  - 通常，应进制直接访问一个对象中数据的实际表示，而应通过操作接口来访问，这这称为信息隐藏
- **属性私有，get/set**



封装的意义：

1. 提高程序的安全性，保护数据
2. 隐藏代码的实现细节
3. 统一接口
4. 系统的可维护性增加了







main

```java
package com.youngbald.oop;

public class Application {
    public static void main(String[] args) {
    Student s1 = new Student() ;
    s1.setName("youngbald");
        System.out.println(s1.getName());

        s1.setAge(999);
        System.out.println(s1.getAge());
    }
}
```



class

```java
package com.youngbald.oop;

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
```





### 继承 inheritance

- 继承的本质是对某一批类的抽象，从而实现对现实世界更好的建模
- extands意思是扩展，子类是弗雷的扩展
- java中类只有单继承，没有多继承。一个儿子只能由一个爸爸，但是一个爸爸能拥有多个儿子
- 继承是类和类之间的一种关系。除此之外，类和类之间的关系还又以来、组合。聚合等
- 继承关系的两个类，一个为子派（派生类），一个为父类（基类）。子类继承父类，使用关键字extends来表示
- 子类和父类之间，从意义上讲应该具有"is a "的关系
- object类
- super
- 方法重写



子类继承了父类，就会拥有父类的全部方法

private的东西无法继承

ctrl +h 可以看到所有类

**在java中，所有的类都直接或者间接继承object类**



super

注意点：

1. super调用父类的构造方法， 必须在构造方法的i一个
2. super必须只能出现子类的方法或者构造方法中
3. super和this不能同时调用构造方法



vs this：

- 代表的对象不同：
  - this：本身调用这个对象
  - super：代表父类人对象的应用
- 前提
  - this：没有继承也可以使用
  - super：只能在继承条件才能使用
- 构造方法
  - this（）； 本类的构造
  - super（）； 父类的构造

person 父类

```java
package com.youngbald.oop.Demo2;

public class Person {

    public Person() {
        System.out.println("persome no can");
    }


    protected  String name ="youngbald";


    public void print(){

        System.out.println("Person");
    }
}
```





子类：

```java
package com.youngbald.oop.Demo2;

public class Student extends Person{

    public Student() {

        //隐藏代码：调用了父类的无参构造
        //super();
        //调用父类的构造器，必须要在子类构造器的第一行

        System.out.println("student no can");
    }

    private String name = "yifan";

    public void print(){

        System.out.println("Student");
    }


    public void test1(){
        print();
        this.print();
        super.print();
    }


    public void test(String name ){
        System.out.println(name);
        System.out.println(this.name);
        System.out.println(super.name);
    }
}
```



### 方法重写 override

重写都是方法的重写，和属性无关

重写：

需要有继承关系，子类重写父类的方法

1. 方法名必须相同
2. 参数列表必须相同
3. 修饰符：范围可以扩大但不能缩小：public> protected>default>private
4. 抛出的异常：范围可以被缩小，但不能被扩大：classNotFoundException-->Exception(大)

重写，子类的方法和父类必须要一致，方法体不同

为什么需要重写：

1. 父类的功能，子类不一定需要，或者不一定满足
2. alt+insert->override

子类：

```java
package com.youngbald.oop.Demo2;

public class A extends B {
    @Override
    public void test() {
        System.out.println("a-->test");
    }
}
```



父类：

```java
package com.youngbald.oop.Demo2;

public class B {
    public void test(){
        System.out.println("b-->test");
    }

}
```



main：

```java
package com.youngbald.oop;

import com.youngbald.oop.Demo2.A;
import com.youngbald.oop.Demo2.B;
import com.youngbald.oop.Demo2.Person;
import com.youngbald.oop.Demo2.Student;

public class Application {
    //静态的方法和非静态的方法区别很大
//    静态方法： 方法的调用只和左边，定义的数据类型有关
//    非静态：重写
    public static void main(String[] args) {


  //方法的调用只和左边，定义的数据类型有关
   A a = new A();
   a.test();

   //父类的引用指向了子类
   B b = new A();// 子类重写了父类的方法
   b.test();




}}
```

output：

a-->test

a-->test

结果是子类override了父类的方法

使用了子类自己的

override跟overload的区别

- **重载 (Overload)** 表示同一个类中可以有多个名称相同的方法，但这些方法的参数列表各不相同（即参数个数、类型或顺序不同）。
- **重写 (Override)** 表示子类中的方法可以与父类中的某个方法的名称 和参数完全相同，通过子类创建的实例对象调用这个方法时，将调用子类中的定义方法，这相当于把父类中定义的那 个完全相同的方法给覆盖了，这也是面向对象编程的多态性的一种表现。（备注：子类覆盖父类的方法时，只能比父类抛出更少的异常，或者是抛出父类抛出的异常 的子异常，因为子类可以解决父类的一些问题，不能比父类有更多的问题。子类方法的访问权限只能比父类的更大，不能更小。如果父类的方法 是 private 类型，那么，子类则不存在覆盖的限制，相当于子类中增加了一个全新的方法。）

### 多态

- 即同一方法可以根据发送对象的不同而采用多种不同的行为方式。
- 一个对象的实际类型是确定的，但可以指向对象的引用的类型有很多
- 多态存在的条件
  - 有继承关系
  - zilei 重写父类方法
  - 父类yinyon给指向子类对象
- 注意：多态是方法的多态，属性没有多态性
- instanceof
- 动态编译：类型：可扩展性

多态的注意事项：

1. 多态是方法的多态，属性没有多态
2. 父类和子类，有联系 类型转换异常 classcastexception
3. 多态存在的条件：继承关系，方法需要重写，父类的引用指向子类对象

不能被重写的方法 也不能实现多态：

1. static方法，属于类，不属于实例
2. final 常量
3. private方法



main

```java
package com.youngbald.oop;

import com.youngbald.oop.Demo3.Person;
import com.youngbald.oop.Demo3.Student;
public class Application {

    public static void main(String[] args) {
        //一个对象的实际类型是确定的
        //可以指向的引用类型就不确定了
        //父类的引用指向子类
        //student 能调用的放大都是自己的或者继承父类
        Student s1 = new Student();
//        父类型，可以指向子类，但是不能调用子类独有的方法
        Person s2 = new Student();
        Object s3 = new Student();

        s2.run();
        s1.run();


        //对象能执行哪里方法，主要看对象左边的类型，和右边关系不大
        ((Student)s2).eat();
        s1.eat();






}}
```



son:

```java
package com.youngbald.oop.Demo3;

public class Student extends Person{
    @Override
    public void run() {
        System.out.println("son run");
    }

    public void eat(){
        System.out.println("eat");
    }
}
```



father:

```java
package com.youngbald.oop.Demo3;

public class Person {
    public void run(){
        System.out.println("run");
    }
}
```





### instanceof和类型转换

判断一个对象是什么类型

可以判断两个类之间是否存在父子关系



```java
package com.youngbald.oop;

import com.youngbald.oop.Demo3.Person;
import com.youngbald.oop.Demo3.Student;
import com.youngbald.oop.Demo3.Teacher;

public class Application {

    public static void main(String[] args) {
        
        
//        System.out.println(X instanceof Y);
//        Obejct >Person >Student
        Object object = new Student();
        System.out.println(object instanceof Student);
        System.out.println(object instanceof Person);
        System.out.println(object instanceof Teacher);
        System.out.println(object instanceof String);
        System.out.println(object instanceof Object);

        Person person = new Student();
        System.out.println(person instanceof Object);
        System.out.println(person instanceof Teacher);
        System.out.println(person instanceof Student);
        System.out.println(person instanceof Person);
        





}}
```





1. 父类的引用指向子类的对象
2. 把子类转换为父类，向上转型
3. 把父类转换为子类，向下转型：强制转换
4. 方便方法的调用，减少重复的代码

抽象：封装、继承、多态



面向对象

就是抽象的编程思想 

类型转换

```java
package com.youngbald.oop;

import com.youngbald.oop.Demo3.Person;
import com.youngbald.oop.Demo3.Student;
import com.youngbald.oop.Demo3.Teacher;

public class Application {

    public static void main(String[] args) {


//类型之间的转换：父-》子
//子类转换为父类，可能丢失自己的本来一些方法

        Person student = new Student();
        ((Student)student).go();

        //student讲这个对象转换为student类型，我们可以使用student类型






}}
```





### static关键字

final之后的类不可以被继承，基本就等于断子绝孙



static：

```java
package com.youngbald.oop.Demo4;

public class Student  {

    private static int age;//静态
    private double score;//非静态变量

    //非静态可以直接调用静态方法
    //静态方法基本就是在当前class里可以被直接调用的一个值，不需要通过类来执行

    public void run(){
        go();
    }
    public static void go(){

    }

    public static void main(String[] args) {
        new Student().run();
        go();


    }
}
```



匿名代码块

静态代码块：

```java
package com.youngbald.oop.Demo4;

public class Person {
    {
//        2.初始值
        System.out.println("匿名代码块");
    }
    static{
//        1：只执行一次
        //静态代码块
        System.out.println("静态代码块");//最先运行
        //只执行一次
    }
//3
    public Person(){
        System.out.println("构造方法");
    }

    public static void main(String[] args) {
        Person p1 = new Person();
        Person p2 = new Person();
    }
}
```





### 抽象类

- abstract 修饰符可以用来修饰方法也可以修饰类，如果修饰方法，那么该方法就是抽象方法;如果修饰类，那么该类就是抽象类。
- 抽象类中可以没有抽象方法，但是又抽象方法的类一定要谁能名为抽象类。
- chouiang类，不能使用new 关键字来创建对象，它是用来让子类继承的、
- 抽象方法，只有方法的声明，没有方法的实现，它是用来让子类实现的。
- 子类继承 抽象类，那么就必须要实现抽象类没有实现的抽象方法，否则该子类也要声明为抽象类。



抽象类

```java
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
```



继承的子类：

```java
package com.youngbald.oop.Demo5;

//需要继承抽象类的话需要implement alt+del
//即需要在a类重写action类里的方法
//抽象类的所有方法，继承了他的子类必须要实现他的方法
//类是单继承，但是接口可以多继承
public class A extends Action{
    @Override
    public void dosomething() {


    }
}
```



### 接口

- 普通类：只有具体实现
- 抽象类：具体实现和规范（抽象方法）都又
- 接口：只有规范！自己无法写方法，专业的约束。约束和实现分离：面向接口编程
- 接口就是规范，定义的是以组规则，体现了现实世界中“如果你是……则必须能……”的思想。如果你是天使则必须能飞。如果你是汽车，则必须能跑。如果你是好人，则必须干掉坏人
- 接口的本质是契约，就像法律一样，指定好后大家都遵守
- OO的精髓，是对对象的抽象，最能体现着一点的就是接口。为什么我们讨论设计模式都只针对具备了抽象能力的语言 c++ java c#，就是因为设计模式所研究的，实际上就是如何合理的去抽象

**声明类的关键字是class，声明接口的关键字是interface**

作用：

1. 约束
2. 定义一些方法，让不同的人实现
3. public abstract
4. public static final
5. 接口不能被实例化，接口中没有构造方法
6. implements可以实现多个接口
7. 必须要重写接口的方法

接口定义：

```java
package com.youngbald.oop.Demo6;

//接口都需要有个实现类
public interface UserService {
    //接口中定义的所有变量都是一个静态的常量
    //一般我们不去定义常量
    public static final int age = 99;
    //接口中的所有定义都是 abstract public
    void add(String name);
    void delete(String name);
    void update(String name);
    void query(String name);
}
```



接口定义：

```java
package com.youngbald.oop.Demo6;

public interface TimeService {
    void timer();
}
```



接口实现：

```java
package com.youngbald.oop.Demo6;

//类可以实现接口 根据关键字 implements 接口
//实现接口中的类必须重写接口中的所有的方法
//利用接口实现多接口
public class UserServiceImpl implements UserService, TimeService{
    @Override
    public void add(String name) {

    }

    @Override
    public void delete(String name) {

    }

    @Override
    public void update(String name) {

    }

    @Override
    public void query(String name) {

    }

    @Override
    public void timer() {

    }
}
```



### 内部类

- 内部类就是一个类的颞部在定义一个类，比如，A类中定义一个B类，那么B类相对A类来说就称为内部类，而A类相对B类来说就是外部类了。

1. 成员内部类
2. 静态内部类
3. 局部内部类
4. 匿名内部类

内部类与静态内部类

```java
package com.youngbald.oop.Demo7;

public class Outer {
    private int ID=10;
    public void out(){
        System.out.println("this is an outer output");

    }


    public class Inner{
        public void in(){
            System.out.println("this is an inner output");
        }
        //可以获得外部类的私有属性
        //静态内部类就不可以获得，因为静态先于外部出现
        public void getID(){
            System.out.println(ID);
        }
    }
}
```

```java
//一个java文件中可以拥有多个class文件，但是只能有一个public class
class A{}
```



局部内部类

```java
package com.youngbald.oop.Demo7;

public class Outer {
    private int ID=10;
    public void method(){
        //局部内部类
        class Inner{

            public void me(){
                
            }
        }

    }



    }
```



匿名内部类

```java
package com.youngbald.oop.Demo7;

public class Test {

    public static void main(String[] args) {
        //没有名字初始化类，不需要将实例保存到变量中
        //匿名内部类
        new Apple().app();
        User user = new User(){

            @Override
            public void interact() {

            }
        };
    }
}


class Apple{
    public void app(){
        System.out.println("eat an apple");
    }
}

interface User{
    void interact();
}
```



## 异常

1. 什么是异常
2. 异常体系结构
3. java异常处理机制
4. 处理异常
5. 自定义异常
6. 总结



什么是异常

- 实际工作中，遇到的情况不可能是非常完美的。比如：你写的某个模块，用户输入不一定符合你的要求，你的程序要打开某个文件，这个文件可能不存在或者文件格式不对，你要读取数据库的数据，数据可能是空的等。我们的程序跑着，内存或者硬盘可能满了
- 软件程序在运行过程中，非常困难遇到刚刚提到的这些异常问题，我们叫异常。英文是exception。
- 异常指程序运行中出现的不期而至的各种情况：文件找不到，网络链接失败，非法参数等
- 异常发生在程序运行期间他影响了正常的程序执行流程



简单分类

- 要理解java异常处理是如果工作的需要掌握一下三种类的异常：
  1. 检查性异常：最具代表的检查下异常是用户错误火问题引起的异常，着是程序员无法遇见的。例如要打开一个不存在文件时，一个异常就发生了，这些异常在编译时不能被简单的忽略
  2. 运行时异常：运行异常是困难被程序员避免的异常。与检查下异常相反，运行时异常可以在编译时被忽略
  3. 错误：错误不是异常，而是脱离程序员控制的问题，错误在代码中通常被忽略。例如当栈溢出时，一个错误就发生了，题目在编译也检查不到的

异常体系结构

- java把异常当作对象来处理，并定义一个基类java.lang.Throwable作为所有异常的超类。
- 在java API中已经定义了许多异常类，这些异常类分为两大类，错误error和异常exeption

![img](https://cdn.nlark.com/yuque/0/2020/png/1281683/1595253960080-0ac945b1-c712-442e-9fa5-43760f5e4503.png)

error

- Error类对象由java虚拟机生成并抛出，大多数错误与代码编写者所执行的操作无关。
- java虚拟机运行错误（virtual machineError), 当jvm不再有继续执行操作所需的内存资源时，将出现outofmemoryerror。这些异常发生时，java虚拟机（JVM）一般会选择线程终止‘
- 还有发生在虚拟机试图执行应用时，如类定义错误（noclassdeffounderro).链接错误linkageerro .这些错误是不可察的，因为他们在应用程序的控制和处理能力之外，而且绝大多数是程序运行时不允许出现的状况



![image-20210228004042057](C:\Users\linyi\AppData\Roaming\Typora\typora-user-images\image-20210228004042057.png)

```java
package com.youngbald.exception;

public class Test2 {
    public static void main(String[] args) {
        int a = 1;
        int b = 0;
        //ctrl+alt+t
        new Test2().test(a,b);

    }
//假设着方法中，处理不了这个异常。方法上抛出异常
    public void test(int a, int b)throws  ArithmeticException
    {
        if(b==0){
            throw new ArithmeticException();//主动抛出异常，一般在方法中使用
        }
        System.out.println(a/b);
    }
}
```





### 自定义异常

自定义异常

- 使用java内置的异常类可以描述在编程时出现的大部分异常情况。除此之外，用户还可以自定义异常，用户自定义异常类，只需要继承exception类即可
- 在程序中使用自定义异常类，答题可以分为以下及格步骤：
  1. 创建自定义异常类
  2. 哎方法中通过throw关键字抛出异常对象
  3. 如果在当前抛出异常的方法中处理异常，可以使用try-catch语句捕获并处理；否则在方法的声明出通过throw关键字知名要抛出给方法调用者的异常，继续进行下一步操作
  4. 在出现异常方法的调用者中捕获并处理异常
  5. 