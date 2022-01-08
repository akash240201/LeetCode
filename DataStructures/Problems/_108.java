package com.akash.Leetcode;

public class _108 {

    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Convert Sorted Array to Binary Search Tree.
     * Memory Usage: 40.5 MB, less than 15.26% of Java online submissions for Convert Sorted Array to Binary Search Tree.
     * @param nums sorted array in ascending order
     * @return returns the BST
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(0, nums.length - 1, nums);
    }

    /**
     * This function creates a BST if we pass the start point, end point and the sorted array
     * @param start from which position the array should be considered to convert it into BST
     * @param end up to which position the array should be considered to convert it into BST
     * @param nums sorted array in ascending order
     * @return returns the BST
     */
    public TreeNode helper(int start, int end, int[] nums) {
        /* if the start is greater than end, this means that we've no item left to fill in the array.
             So we should exit from the function call */
        if(start > end) {
            return null;
        }
        TreeNode treeNode = new TreeNode(); //create a new tree
        int mid = (start + end) / 2;
        treeNode.val = nums[mid]; //set the mid element of the sorted array to the root of the BST
        treeNode.left = helper(start, mid - 1, nums); //recursively set the left sub tree of the BST
        treeNode.right = helper(mid + 1, end, nums); //recursively set the right sub tree of the BST
        return treeNode;
    }
}

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
 }
