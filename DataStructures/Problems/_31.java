package com.akash.Leetcode;

public class _31 {
    //This is brute force method, not accepted by leetcode due to runtime error
    public static void nextPermutation(int[] nums) {
        for(int i = nums.length - 1; i > 0; i--) {
            for(int j = i - 1; j >= 0; j--) {
                if(nums[i] > nums[j]) {
                    swap(nums, i, j);
                    return;
                }
            }
        }
        //If the program upto this line, then the array is sorted in descending order. We need to reverse this array
        int length = nums.length;
        for(int i = 0; i<length/2; i++) {
            swap(nums, i, length - i);
        }
    }

    //This solution is more efficient and accepted by leetcode
    public static void nextPermutation1(int [] nums) {
        int i, j;
        for(i = nums.length - 1; i > 0; i--) {
            if(nums[i-1] < nums[i]) {
                j = i - 1;
                for(int k = nums.length - 1; k > j; k--) {
                    if(nums[k] > nums[j]) {
                        swap(nums, j, k);
                        reverse(nums, j+1);
                        return;
                    }
                }
            }
        }
        reverse(nums, 0);
    }

    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void reverse(int[] array, int start) {
        int i = start; int j = array.length - 1;
        while(i < j) {
            swap(array, i, j);
            i++;
            j--;
        }
    }
}
