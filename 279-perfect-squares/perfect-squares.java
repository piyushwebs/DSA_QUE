class Solution {
    public int numSquares(int n) {
        int val = (int)Math.sqrt(n);
        if(val*val == n)
        {
            return 1;
        }
        int[] dp = new int[n+1];
        Arrays.fill(dp,Integer.MAX_VALUE);

      
            dp[n] = checkPow(n,0,dp);

        return dp[n];
    }
    public int checkPow(int n,int sum,int[] dp)
    {
        
        if(sum>n)
        {
            return Integer.MAX_VALUE;
        }
        
        if(sum == n)
        {
            return 0;
        }
        if(dp[sum]!=Integer.MAX_VALUE)
        {
            return dp[sum];
        }
        int ans = Integer.MAX_VALUE;
        for(int i=1;Math.pow(i,2)<n;i++)
        {
            int rem = checkPow(n,sum+(int)Math.pow(i,2),dp);
            if(rem!=Integer.MAX_VALUE)
            {
                ans = Math.min(ans,rem+1);
            }
        }
        dp[sum] = ans;
        return dp[sum];
    }
}