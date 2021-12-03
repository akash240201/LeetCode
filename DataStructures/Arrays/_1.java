package com.akash.Leetcode;

import java.util.HashMap;

public class _1 {
  //this solution has time complexity O(n). Memory required is 39MB. It is accepted by leetcode. 
    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        HashMap<Integer, Integer> complement = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            if(complement.containsKey(nums[i])) {
                result[0] = complement.get(nums[i]);
                result[1] = i;
                return result;
            } else {
                complement.put(target - nums[i], i);
            }
        }
        int[] empty = {};
        return empty;
    }
}
