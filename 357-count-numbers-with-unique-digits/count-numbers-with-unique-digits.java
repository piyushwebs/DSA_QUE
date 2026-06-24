class Solution {
    int[] dp = new int[9];
    public int countNumbersWithUniqueDigits(int n) {
        if(n==0) return 1;
        if(dp[n]!=0) return dp[n];
        int ans = 0;
        int mul = 9;
        int c =9;
        for(int i=1;i<n;i++)
        {
            mul *= c;
            c--;
        }
        dp[n] = mul;
        ans = ans + mul + countNumbersWithUniqueDigits(n-1);
        return ans;
    }
}