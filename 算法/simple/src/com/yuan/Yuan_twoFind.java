package com.yuan;

import java.util.Arrays;

/**
 * @module:
 * @description:
 * @author: yuan_boss
 * @create: 2022-07-22 17:51
 **/
public class Yuan_twoFind {

    /*二分查找*/
    public static boolean find(int arr[] ,int value){
        if (arr == null || arr.length==0){
            return false;
        }
        int L = 0;
        int R = arr.length-1;
        while (L <=R ){
            int mid = (L+R)/2;
            if (arr[mid] == value){
               return true;
            }else if (arr[mid] > value){
                R = mid - 1;
            }else {
                L = mid + 1;
            }
        }
        return false;
    }


    /*arr有序，arr>=num 最左*/
    public static int mostLeftNoLessNumIndex(int arr[],int num){
        if (arr == null || arr.length == 0){
            return -1;
        }
        int L = 0;
        int R = arr.length-1;
        int ans = -1; //先表示整个数组都没有 >= num
        while (L <= R) {
            int mid = (L+R)/2;
            if (arr[mid] >= num){
                ans = mid;
                R = mid - 1;
            }else {
                L = mid + 1;
            }
        }
        return ans;

    }

    /*arr有序，arr>=num 最左*/
    public static int test(int arr[],int num){
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == num){
                return i;
            }
        }
        return -1;
    }


    /*使用对数器校验*/
    public static void main(String[] args) {

        int maxLen = 10;
        int maxValue = 100;
        int testTime = 10000;
        int value = (int)((maxValue+1) * Math.random()) - (int)(maxValue * Math.random());
        boolean success = true;

        for (int i = 0; i < testTime; i++) {
            int[] arr = CompareUtil.lenRandomValueRandom(maxLen, maxValue);
            Arrays.sort(arr);
            if (test(arr,value) != mostLeftNoLessNumIndex(arr,value)){
                CompareUtil.printArray(arr);
                System.out.println(value);
                System.out.println(test(arr,value));
                System.out.println(mostLeftNoLessNumIndex(arr,value));
                success = false;
                break;
            }
        }
        System.out.println(success ? "Nice" : "Fucking fucked");


    }
}
