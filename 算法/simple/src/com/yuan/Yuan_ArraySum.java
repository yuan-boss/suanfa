package com.yuan;

/**
 * @module:
 * @description:
 * @author: yuan_boss
 * @create: 2022-07-22 09:54
 **/
public class Yuan_ArraySum {


    public static class RangeSum{
        private int[] preSum;

        public RangeSum(int[] array){
            int N = array.length;
            preSum = new int[N];
            preSum[0] = array[0];
            for (int i = 1; i < N; i++) {
                preSum[i] = preSum[i-1] + array[i];
            }
        }


        public int rangeSum(int L,int R){
            return L==0 ? preSum[R] : preSum[R] - preSum[L-1];
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3};
        int sum = new RangeSum(arr).rangeSum(0,0);
        System.out.println(sum);
    }
}
