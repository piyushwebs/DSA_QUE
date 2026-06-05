class Solution {
    int[] dp = new int[20];
    
    public int numTrees(int n) {
        dp[0] = 1;
        dp[1] = 1;
        if(n==1) return 1;
        int left = 0;
        int right = n-1;
        int ans = 0;
        while(left<n)
        {
            if(dp[left]==0)
            {
                dp[left] = numTrees(left);
            }
            if(dp[right]==0)
            {
                dp[right] = numTrees(right);
            }
            ans += (dp[left]*dp[right]);
          left++;
          right--;
        }
        dp[n] = ans;
        return dp[n];
    }
}