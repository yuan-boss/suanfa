package com.yuan;

/**
 * @module:
 * @description:
 * @author: yuan_boss
 * @create: 2022-07-22 16:13
 **/
public class CompareUtil {

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

    /*产生一个数组arr,arr长度[0,maxLen-1],arr中每个值在[0,maxValue-1]*/
    public static int[] lenRandomValueRandom(int maxLen,int maxValue){
        int len = (int)(Math.random() * maxLen);
        int[] ans = new int[len];
        for (int i = 0; i < len; i++) {
            ans[i] = (int)(Math.random() * maxValue);
        }
        return ans;
    }

    /*数组拷贝*/
    public static int [] copyArray(int[] arr){
        int[] ans = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            ans[i] = arr[i];
        }
        return ans;
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

    /*验证两个数组的值是否一样*/
    /*保证输入的arr2,arr2一定等长*/
    public static boolean equalValues(int[] arr1,int[] arr2){
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]){
                return false;
            }
        }
        return true;

    }

    /*判断一个数组是否是升序*/
    public static boolean isSorted(int arr[]){
        if (arr.length < 2){
            return true;
        }
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (min > arr[i]){
                return false;
            }
            min = arr[i];
        }
        return true;

    }


    public static void main(String[] args) {
        int maxLen = 5;
        int maxValue = 5;
        int testTime = 1000;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = lenRandomValueRandom(maxLen, maxValue);
            int[] temp = copyArray(arr1);
            Yuan_Sort.selectSort(arr1);

            if (!isSorted(arr1)){
                for (int j = 0; j < temp.length; j++) {
                    System.out.print(temp[j] + " ");
                }
                System.out.println();
                System.out.println("有问题");
                break;
            }
        }
    }


}
