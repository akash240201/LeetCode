package com.akash.Leetcode;

import java.util.Arrays;

public class _88 {
    public static void main(String[] args) {
        int[] nums1 = {1,3,5,9,18,24,0,0,0,0,0,0,0,0};
        int[] nums2 = {2,3,4,5,6,7,8,9};

        merge(nums1, 6, nums2, 8);
        System.out.println(Arrays.toString(nums1)); //output is: [1, 2, 3, 3, 4, 5, 5, 6, 7, 8, 9, 9, 18, 24]
    }

    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Merge Sorted Array.
     * Memory Usage: 39.1 MB, less than 46.02% of Java online submissions for Merge Sorted Array.
     * @param nums1 non-decreasing ascending array of integers
     * @param m number of elements in nums1 except the trailing zeros
     * @param nums2 non-decreasing ascending array of integers
     * @param n number of elements in nums2
     */
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        nums1 = recreate(nums1, m, nums2, n);
        int j = m;
        for(int i = 0; i < nums1.length; i++) {
            //if the index j surpasses the length of the array then exit from the method
            if(j == nums1.length) {
                return;
            }
            //if the number in i position is greater than the element in j position (elements from nums2), then move it to the position j
            if(nums1[i] > nums1[j]) {
                move(j, i, nums1);
                j++;
            }
            if(i == j) {
                return;
            }
        }
    }

    /**
     * This function recreates the array nums1.
     * It replaces all the trailing zeros of nums1 with the values from nums2
     * e.g. if the input is: [1,2,3,0,0,0,0] and [7,8,9,10] then the output will be [1,2,3,7,8,9,10]
     * @param nums1 array of ints
     * @param m length of nums1 except all the zeros
     * @param nums2 array of ints
     * @param n length of nums2
     * @return returns the array nums1 after replacing the zeros
     */
    public static int[] recreate(int[] nums1, int m, int[] nums2, int n) {
        int j = 0;
        for(int i = m; i < m + n; i++) {
            nums1[i] = nums2[j];
            j++;
        }
        return nums1;
    }

    /**
     * This function moves elements from one position to another while keeping the elements before or after the elements intact
     * @param from from which position the element has to be moved
     * @param to to which position the element has to be moved
     * @param array array of ints
     */
    public static void move(int from, int to, int[] array) {
        //if starting and ending is same, then exit from the method
        if(from == to) {
            return;
        }
        int temp = array[from]; //store the element at 'from' to a variable 'temp'
        //increase the position of all the elements (from position 'from - 1' to position 'to')
        for(int i = from - 1; i >= to; i--) {
            array[i + 1] =  array[i];
        }
        array[to] = temp;
    }
}
