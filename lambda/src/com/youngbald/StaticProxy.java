package com.youngbald;
//静态代理模式
public class StaticProxy {
    public static void main(String[] args) {

        new Thread(()-> System.out.println("我哎你i")).start();
        new WeddingCompany(new You()).HappyMarry();
    }
}
interface  Marry{
    void HappyMarry();

    }

//真实角色，你去结婚
    class You implements Marry{

        @Override
        public void HappyMarry() {
            System.out.println("要结婚了");
        }
    }


    //代理角色，帮助你结婚
    class WeddingCompany implements Marry{
        private Marry target;
        public WeddingCompany(Marry target){
            this.target =target;
        }
        @Override
        public void HappyMarry() {
            before();
            this.target.HappyMarry();
            after();
        }

        private void after(){
            System.out.println("结婚之后");
        }
        private void before(){
            System.out.println("结婚之前");

        }
    }