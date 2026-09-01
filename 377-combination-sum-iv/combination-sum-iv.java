class Solution {
    public int combinationSum4(int[] nums, int target) {
        int n = nums.length;
        int[] dp = new int[target+1];
        Arrays.fill(dp,-1);
        return findComb(nums,n,target,dp);
    }
    public int findComb(int[] nums,int n,int target,int[] dp)
    {
      
        if(target<0) return 0;
        if(target==0) return 1;
        if(dp[target]!=-1)
        {
            return dp[target];
        }
       
        int val = 0;
       
        for(int i=0;i<n;i++)
        {
           val += findComb(nums,n,target-nums[i],dp); 
        }

        return dp[target] = val;
    }
}