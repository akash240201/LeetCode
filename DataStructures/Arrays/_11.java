package com.akash.Leetcode;

public class _11 {
    //this solution is accepted by leetcode
    //runtime 4ms
    //memory used 79MB
    
    public static int maxArea(int[] height) {
        int max_area = 0; //initially the max area is set to 0
        int i = height.length - 1;
        int p = 0, q = height.length - 1; //these two are pointers are here to change the left and right pointer's
        int right = height[q]; //this is the left pointer
        int left = height[p]; //this is the right pointer
        while(i >= 1) {
            int temp = min(left, right) * i;
            if(temp > max_area) {
                max_area = temp;
            }
            if(left < right) {
                left = height[++p];
            }
            else if(left > right) {
                right = height[--q];
            }
            else {
                right = height[--q];
            }
            i--;
        }
        return max_area;
    }

    public static int min(int a, int b) {
        if(a<b) return a;
        else return b;
    }
}
