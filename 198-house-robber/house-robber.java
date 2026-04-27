class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp,-1);
        int val0 = robHouse(nums,n,0,0,dp);
        int val1 = robHouse(nums,n,1,0,dp);
        return Math.max(val0,val1);
    }
    public int robHouse(int[] nums,int n,int i,int ans,int[] dp)
    {
      if(i>n-1)
       {
        return 0;
       }
       if(dp[i]!=-1)
       {
        return dp[i];
       }
       int val1 = robHouse(nums,n,i+2,ans,dp)+nums[i];
       int val2 = robHouse(nums,n,i+3,ans,dp)+nums[i];
       dp[i] = Math.max(val1,val2);
       return dp[i];
    }
}