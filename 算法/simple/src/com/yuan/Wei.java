package com.yuan;

/**
 * @module:
 * @description:
 * @author: yuan_boss
 * @create: 2022-07-21 12:18
 **/
public class Wei {


    /*打印整数的32进制*/
    public static void print(int num){
        for (int i = 31; i >= 0; i--) {
            System.out.print((num & (1<<i)) == 0 ? "0" : "1");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int c = ~0+1;
        print(c);
//        System.out.println((3==3) && (1==1));
    }
}
