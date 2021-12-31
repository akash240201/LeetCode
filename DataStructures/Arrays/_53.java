package com.akash.Leetcode;

public class _53 {
    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int ans = maxSubArray(nums);
        int ans1 = maxSubArray1(nums);
        System.out.println(ans);
        System.out.println(ans1);
    }

    /**
     * This is efficient application of Kadane's algorithm
     * This solution is accepted by leetcode
     * time complexity is O(n)
     * @param nums an unsorted array of integers
     * @return maximum sum of all the elements in a contiguous sub array
     */
    public static int maxSubArray(int[] nums) {
        int n = nums.length;
        int currentSum = 0;
        int maxSum = Integer.MIN_VALUE;
        //for each loop
        for (int num : nums) {
            currentSum += num;
            if (currentSum > maxSum) {
                maxSum = currentSum;
            }
            if (currentSum < 0) {
                currentSum = 0;
            }
        }
        return maxSum;
    }

    /**
     * This is brute force application of Kadane's algorithm
     * Time complexity is O(n^2)
     * this solution is not accepted by leetcode
     * @param nums an unsorted array of integers
     * @return the maximum sum of sub array of the given array
     */
    public static int maxSubArray1(int[] nums) {
        int n = nums.length;
        int maxSum = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++) {
            int currentSum = 0;
            for(int j = i; j < n; j++) {
                currentSum += nums[j];
                if(currentSum > maxSum) {
                    maxSum = currentSum;
                }
            }
        }
        return maxSum;
    }
}
