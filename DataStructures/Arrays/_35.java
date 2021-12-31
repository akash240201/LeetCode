package com.akash.Leetcode;

public class _35 {
    public static void main(String[] args) {
        int[] nums = {1,3,5,6};
        int ans = searchInsert(nums, 7);
        System.out.println(ans);
    }

    /**
     * Binary search for the target in the given array
     * If the target is found then return its position in the array
     * If the target is not found then return the position where it should be if it was present
     * @param nums sorted array of integers
     * @param target integer type
     * @return int position in the array where the target is present or where it should be
     */
    public static int searchInsert(int[] nums, int target) {
        int high, low, mid;
        high = nums.length - 1;
        low = 0;
        mid = (low + high) / 2;
        while(mid != low || mid != high) {
            if(target < nums[mid]) {
                high = mid;
                mid = (low + high) / 2;
            } else if(target > nums[mid]) {
                low = mid + 1;
                mid = (low + high) / 2;
            } else {
                return mid;
            }
        }
        if((target > nums[nums.length - 1]) ) {
            return (mid + 1);
        } else {
            return low;
        }
    }
}
