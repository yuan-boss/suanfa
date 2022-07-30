package com.yuan;

/**
 * @module:
 * @description:
 * @author: yuan_boss
 * @create: 2022-07-21 17:11
 **/
public class Yuan_Sort {
    /*打印数组*/
    public static void printArray(int arr[]){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+ " ");
        }
        System.out.println();
    }

    /*交换*/
    public static void swap(int arr[],int i,int j){
        if (i==j){
            return;
        }
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;

    }

    /*选择排序*/
    public static void selectSort(int arr[]){
        if (arr==null || arr.length < 2){
            return;
        }
        int N = arr.length;
        for (int i = 0; i < N; i++) {
            int minValueIndex = i;
            for (int j = i+1; j < N ; j++) {
                minValueIndex = (arr[j] < arr[minValueIndex] ? j : minValueIndex);
/*                if (arr[j] < arr[minValueIndex]){
                    minValueIndex = j;
                }*/
            }
            swap(arr,minValueIndex,i);

        }
    }
    /*冒泡排序*/
    public  static void bubbleSort(int arr[]){
        if (arr==null || arr.length < 2){
            return;
        }
        int N= arr.length;
        for (int end = N-1; end >= 0; end--) {
            for (int i = 0; i < end; i++) {
                if (arr[i] > arr[i+1]){
                    swap(arr,i,i+1);
                }
            }
        }



    }

    /*插入排序1*/

    public static void insertSort1(int arr[]){
        if (arr==null || arr.length < 2){
            return;
        }

        int N = arr.length;
        for (int end = 1; end < N; end++) {
            int newNumIndex = end;
            while ((newNumIndex-1) >=0 && arr[newNumIndex-1] > arr[newNumIndex]){
                swap(arr,newNumIndex,newNumIndex-1);
                newNumIndex--;
            }

        }
    }
    /*插入排序2*/

    public static void insertSort2(int arr[]){
        if (arr==null || arr.length < 2){
            return;
        }

        int N = arr.length;
        for (int end = 1; end < N; end++) {
            for (int pre = end; pre -1 >= 0 && arr[pre] < arr[pre-1] ; pre--) {
                swap(arr,pre,pre-1);
            }

        }
    }
    public static void main(String[] args) {
        int[] arr = {1,5,6,9,2,3,0};
        printArray(arr);
        selectSort(arr);
        printArray(arr);

    }
}
