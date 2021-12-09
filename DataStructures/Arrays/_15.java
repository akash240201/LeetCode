package com.akash.Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _15 {
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        //System.out.println(Arrays.toString(nums)); //checkpoint print
        List<List<Integer>> result = new ArrayList<>();
        for(int i = 0; i<nums.length; i++) {
            //System.out.println(i + " = " + nums[i]); //checkpoint print
            if(i>0 && nums[i] == nums[i-1]) {
                continue;
            }
            int left = i+1, right = nums.length - 1;
            while(left<right) {
                List<Integer> answer = new ArrayList<>();
                int sum = nums[left] + nums[right];
                int reqdSum = -nums[i];
                //System.out.println("        sum = " + sum); //checkpoint print
                if(sum == -nums[i]) {
                    answer.add(nums[i]);
                    answer.add(nums[left]);
                    answer.add(nums[right]);
                    System.out.println(Arrays.toString(answer.toArray()));
                    if(!result.contains(answer)) {
                        result.add(answer);
                    }
                    left++;
                } else if(sum < -nums[i]) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return result;
    }
}
