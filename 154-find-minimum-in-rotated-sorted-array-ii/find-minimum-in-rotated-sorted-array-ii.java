class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        int i =0;
        int min = Integer.MAX_VALUE;
        while(i<n)
        {
            min = Math.min(nums[i],min);
            i++;
        }
        return min;
    }
}