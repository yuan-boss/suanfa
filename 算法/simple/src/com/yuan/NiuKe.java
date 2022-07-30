package com.yuan;

/**
 * @module:
 * @description:
 * @author: yuan_boss
 * @create: 2022-07-22 18:17
 **/
public class NiuKe {
    public static void main(String[] args) {


        int[] arr = {2,3,1,0,2,5,3};
        System.out.println(find(arr));
    }

    public static int find(int[] arr){
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if (arr[i]==arr[j]){
                    res = arr[i];
                    return res;
                }

            }
        }
        return -1;
    }
}
