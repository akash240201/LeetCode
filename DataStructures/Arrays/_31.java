public class _31 {
    //this is brute force solution and LeetCode does not accept this solution due to runtime error
    public void nextPermutation(int[] nums) {
        for(int i = nums.length - 1; i > 0; i--) {
            for(int j = i - 1; j >= 0; j--) {
                if(nums[i] > nums[j]) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                    return;
                }
            }
        }
        //if the program upto this line, then the array is sorted in descending order. We need to reverse this array
        int length = nums.length;
        for(int i = 0; i<length/2; i++) {
            int temp = nums[i];
            nums[i] = nums[length - i];
            nums[length - 1] = temp;
        }
    }
}
