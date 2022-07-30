package com.yuan;

/**
 * @module:
 * @description:
 * @author: yuan_boss
 * @create: 2022-07-23 10:59
 **/
public class LocalMin {

    /*
    * 局部最小值
    * 就是指一个数字的左边比这个数字大，右边也比这个数字大，那这个数字就是局部最小的
    * 边界1：如果最左边的数字比第二个数字小，因为他左边没有数字了，所以他就是局部最小的
    * 边界2：如果最右边的数字比倒数第二个数字小，因为他右边没有数字了，所以最右边的数字就是局部最小的
    * 如果两个边界都不符合，那中间必然有个局部最小值
    * */


    /*数组中与某个数字相邻的数字不会与那个数字重复，返回局部最小的索引*/
    public static int minIndex(int[] arr){
        /*如果数组为空，则不合法，返回-1*/
        if (arr == null || arr.length == 0){
            return -1;
        }
        int N = arr.length;
        /*如果数组只有一个数字，那么这个数字就是局部最小值*/
        if (arr.length == 1){
            return 0;
        }

        if (arr[0] < arr[1] ){
            return 0;
        }
        if (arr[N-1] < arr[N-2]){
            return N-1;
        }
        int L = 0;
        int R = arr.length-1;
        while (L < R - 1 ){
            int mid = (L+R)/2;
            if (arr[mid] < arr[mid-1] && arr[mid] < arr[mid+1]){
                return mid;
            }
            if (arr[mid] > arr[mid-1]){
                R = mid - 1;
            }else {
                L = mid + 1;
            }
        }
        return arr[L] < arr[R] ? L : R;

    }


    /*随机产生一个数组,而且相邻数不相等（一个数字的相邻两个数字不会和这个数字相同）*/
    public static int[] randomMinIndexArray(int maxLen,int maxValue){
        int len = (int) (Math.random() * maxLen);
        int[] ans = new int[len];
        if (len > 0){
            ans[0] = (int) (Math.random() * maxValue);
            for (int i = 1; i < ans.length; i++) {
                do {
                    ans[i] = (int) (Math.random() * maxValue);
                }while (ans[i] == ans[i-1]);
            }
        }
        return ans;
    }

    /*用于测试局部最小值的下标是否正确*/
    public static boolean check(int arr[],int minIndex){
        if (arr.length == 0){
            return minIndex == -1;
        }

        int left = minIndex-1;
        int right = minIndex+1;
        boolean leftBigger = left >= 0 ? arr[left] > arr[minIndex] : true;
        boolean rightBigger = right < arr.length ? arr[right] > arr[minIndex] : true;

        return leftBigger && rightBigger;

    }


    public static void main(String[] args) {
        int maxLen = 10;
        int maxValue = 100;
        int testTime = 10000;
        System.out.println("测试开始");
        for (int i = 0; i < testTime; i++) {
            int[] arr = randomMinIndexArray(maxLen, maxValue);
            int minIndex = minIndex(arr);
            if (!check(arr,minIndex)){
                System.out.println(minIndex);
                break;

            }
        }
        System.out.println("测试结束");

    }
}
