class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        if(n==1) return nums[0];
        Arrays.fill(dp,-1);
        int val1 = sumUp(nums,dp,0,0);
        int val2 = sumUp(nums,dp,1,0);
        return Math.max(val1,val2);
    }
    public int sumUp(int[] nums,int[] dp,int i,int sum)
    {
        if(i>=nums.length)
        {
            return 0;
        }
        if(dp[i]!=-1)
        {
            return dp[i];
        }
        int val1 = sumUp(nums,dp,i+2,sum);
        int val2 = sumUp(nums,dp,i+3,sum);
        dp[i] = nums[i]+Math.max(val1,val2);
        return dp[i];
    }
}