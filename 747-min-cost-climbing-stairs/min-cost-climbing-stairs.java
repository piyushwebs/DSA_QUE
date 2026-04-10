class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length+1];
        Arrays.fill(dp,-1);
        int n = cost.length;
        int val1 = findMin(cost,-1,dp);
        return val1;
    }
    public int findMin(int[] cost,int i,int[] dp)
    {
        if(i==cost.length)
        {
            return 0;
        }
        if(i!=-1 && dp[i]!=-1)
        {
            return dp[i];
        }
        int left = findMin(cost,i+1,dp);
        int right = 0;
        if(i!=cost.length-1)
        {
           right = findMin(cost,i+2,dp);
        }
        if(i!=-1)
        {
          dp[i]=Math.min(left+cost[i],right+cost[i]);
          return dp[i];
        }
        else
        {
            return Math.min(dp[0],dp[1]);
        }
       
    }
}