package com.yuan;

/**
 * @module:
 * @description:选择排序
 * @author: yuan_boss
 * @create: 2022-07-21 15:29
 **/
public class Sort {


    public static void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void printArray(int [] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }


    /*选择排序*/
    public static void selectSort(int [] arr){
        //边界条件：为空，只有一个数字，不需要排序

        if (arr==null || arr.length < 2){
            return;
        }
        int N = arr.length;
        for (int i = 0; i < N; i++) {
            int minValueIndex = i;
            for (int j = i+1; j < N; j++) {
                minValueIndex = arr[j] < arr[minValueIndex] ? j : minValueIndex;
            }
            swap(arr,i,minValueIndex);
        }
    }

    /*冒泡排序*/
    public static void bubbleSort(int[] arr){
        //边界条件：为空，只有一个数字，不需要排序
        if (arr==null || arr.length < 2){
            return;
        }
        int N = arr.length;
        for (int end = N-1; end >=0  ; end--) {

            for (int second = 1; second <= end; second++) {
                if (arr[second-1] > arr[second]){
                    swap(arr,second,second-1);
                }
            }
        }
    }

    /*插入排序1*/
    public static void insertSort1(int[] arr){
        //边界条件：为空，只有一个数字，不需要排序
        if (arr==null || arr.length < 2){
            return;
        }

        int N = arr.length;
        for (int end = 1; end < N; end++) {
            int newNumIndex = end;
            while (newNumIndex-1 >=0 && arr[newNumIndex] < arr[newNumIndex-1]){
                swap(arr,newNumIndex,newNumIndex-1);
                newNumIndex--;
            }
        }
    }

    /*插入排序1*/
    public static void insertSort2(int[] arr){
        //边界条件：为空，只有一个数字，不需要排序
        if (arr==null || arr.length < 2){
            return;
        }

        int N = arr.length;
        for (int end = 1; end < N; end++) {
            for (int pre = end-1; pre >= 0 && arr[pre] > arr[pre+1]; pre--) {
                swap(arr,pre,pre+1);
            }
        }
    }


    public static void main(String[] args) {
        int [] arr = {2,5,8,4,1,3,9};
        printArray(arr);
        insertSort2(arr);
        printArray(arr);
    }
}
