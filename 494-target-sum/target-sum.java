class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int val = 0;
        if(target>=0)
        {
            val = target;
        }
        int[][] dp = new int[n][val];
        for(int i=0;i<n;i++)
        {
            Arrays.fill(dp[i],-1);
        }
        return numWays(nums,target,n,0,0,0,dp);
    }
    public int numWays(int[] nums,int target,int n,int sum,int idx,int total,int[][] dp)
    {
        if(idx == n )
        {
            return sum==target?1:0;
        }
        if(sum>=0 && sum<target && dp[idx][sum]!=-1)
        {
            return dp[idx][sum];
        }
       
        int minus = numWays(nums,target,n,sum-(nums[idx]),idx+1,total,dp);
        int plus = numWays(nums,target,n,sum+nums[idx],idx+1,total,dp);
        
        if(sum>=0 && sum<target)
        {
            dp[idx][sum] = minus+plus;
        }

        return minus+plus;
    }
}