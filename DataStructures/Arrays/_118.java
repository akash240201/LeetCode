package com.akash.Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _118 {
    public static void main(String[] args) {
        List<List<Integer>> result = generate(6);
        for(int i = 0; i < result.size(); i++) {
            /* Copy all the elements of the list of integers to an array by using the toArray() method */
            Integer[] arr = result.get(i).toArray(new Integer[0]);
            System.out.println(Arrays.toString(arr));
        }
    }

    /**
     * Runtime: 1 ms, faster than 21.96% of Java online submissions for Pascal's Triangle.
     * Memory Usage: 38.6 MB, less than 12.01% of Java online submissions for Pascal's Triangle.
     * @param numRows
     * @return
     */
    public static List<List<Integer>> generate(int numRows) {
        int i = 0;
        List<List<Integer>> ans = new ArrayList<>(); //initializing a list of list of integers. This is the final answer
        // initializing a list of integers, 'temp'. This will containing the last list that is being added to the 'ans' list
        List<Integer> temp = new ArrayList<>();
        while(i < numRows) {
            //this is the list of integers that will be added to the 'ans' after being completed as per the rule
            List<Integer> row = new ArrayList<>();
            if(i == 0) {
                row.add(1);
            } else {
                for(int j = 0; j <= temp.size(); j++) {
                    if(j == 0 || j == temp.size()) {
                        row.add(1); //first and the last element of any row is 1
                    } else {
                        /* all the elements, except the first and last two, is the sum of the previous row's
                        two consecutive elements (according to Pascal's triangle rule*/
                        row.add(temp.get(j-1) + temp.get(j));
                    }
                }
            }
            temp = row; // set 'temp' to the 'row', as it is now the last element of 'ans'
            ans.add(row); // add 'row' to the 'ans'
            i++;
        }
        return ans;
    }
}
