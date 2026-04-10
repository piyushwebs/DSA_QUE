class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length+1];
        Arrays.fill(dp,-1);
        int val1 = findMin(cost,0,dp);
        int val2 = findMin(cost,1,dp);
        dp[0] = Math.min(val1,val2);
        return dp[0];
    }
    public int findMin(int[] cost,int i,int[] dp)
    {
        if(i==cost.length)
        {
            return 0;
        }
        if(dp[i]!=-1)
        {
            return dp[i];
        }
        int left = findMin(cost,i+1,dp);
        int right = 0;
        if(i!=cost.length-1)
        {
           right = findMin(cost,i+2,dp);
        }
        dp[i]=Math.min(left+cost[i],right+cost[i]);
        return dp[i];
    }
}