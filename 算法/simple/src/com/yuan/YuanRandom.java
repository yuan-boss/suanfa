package com.yuan;

/**
 * @module:
 * @description:
 * @author: yuan_boss
 * @create: 2022-07-22 10:54
 **/
public class YuanRandom {



    public static double xToXPower2(){
        return Math.max(Math.random(),Math.random());
    }
    public static double xToXPower3(){
        return Math.max(Math.max(Math.random(),Math.random()),Math.random());
    }

    //想象为lib里的函数，不能改变
    //1--5的等概率随机数，因为Math.random()是[0,1）的等概率随机数
    public static int f1(){
        return (int)(Math.random() * 5) + 1;
    }

    //返回 0 1 的等概率随机数
    public static int f2(){
        int ans = 0;
        do {
            ans = f1();
        }while (ans == 3);
        return ans < 3 ? 0 : 1;
    }

    /*17-56的等概率随机数*/
    public static int g1(){
        return (int) (Math.random() * 40) + 17;
    }



    /*0-7等概率随机*/
    public static int f3(){

        return (f2() << 2) + (f2() << 1) + f2();

    }

    /*0-6等概率随机*/
    public static int f4(){
        int ans = 0;
        do {
            ans = f3();
        }while (ans == 7);
        return ans;
    }

    /*1-7等概率随机*/
    public static int f5(){
        return f4()+1;
    }

    /*1-7等概率随机*/
    public static int f6(){
        int ans = 0;
        do {
            ans = f3();
        }while (ans == 0);
        return ans;
    }

    /*0-39等概率随机*/
    public static int f7(){
        int temp = 0;
        do {
            temp = (f2()<<5) + (f2()<<4 ) + (f2()<<3) + (f2()<<2) + (f2()<<1)  + f2();
        }while (temp > 39);
        return temp;
    }
    /*17-56等概率随机*/

    public static int f8(){
        return f7() + 17;
    }

    /*只知道x（）会以固定概率返回0 1，并不是等概率， 无法看到x的内容*/
    public  static int x(){
        return Math.random() < 0.64 ? 0 : 1;
    }

    //等概率返回0 1
    public static int y(){
        int ans = 0;
        do {
            ans = x();
        }while (ans == x());
        return ans;
    }


    public static void main(String[] args) {
        int testTimes = 1000000;
        int count = 0;
        double x = 0.1;
        for (int i = 0; i < testTimes; i++) {
            if (xToXPower3() < x){
                count++;
            }
        }
        System.out.println((double) count / (double) testTimes);
        System.out.println(Math.pow(x,3));
        System.out.println("=========================");
        count = 0;

        for (int i = 0; i < testTimes; i++) {
            if (f2() == 0){
                count++;
            }
        }
        System.out.println((double) count / (double) testTimes);

        System.out.println("=========================");
        int[] counts = new int[57];
        int ans = 0;
        count = 0;
        for (int i = 0; i < testTimes; i++) {
            ans = f8();
            counts[ans]++;
        }
        for (int i = 17; i < 57; i++) {
            System.out.println( i+"出现了" + counts[i] +"次" );
        }

        System.out.println("=====================================");
        System.out.println(f2()<<5 + f2()<<4 + f2()<<3 + f2()<<2 + f2()<<1 + f2());
        System.out.println(((((f2()<<5 + f2())<<4 + f2())<<3 + f2())<<2 + f2())<<1 + f2());
    }



}
