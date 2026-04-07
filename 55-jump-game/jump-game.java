class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        if(n==1) return true;
        int i = 0;
        int max = Integer.MIN_VALUE;
        while(i<n-1)
        {
          int val = i+nums[i];
          if(nums[i]==0 && max<=i) return false; 
          max = Math.max(val,max);
          i++;
        }
        if(max>=n-1) return true;
        return false;
    }
}