class Solution {
    int ans = 0;
    public int numDecodings(String s) {
        int n = s.length();
        if(s.charAt(0) == '0') return 0;
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        decode(s,n,0,dp);
        return dp[0];
    }
    public int decode(String s, int n, int start,int[] dp)
    {
        if((start) == n)
        { 
            return 1;
        }
        if(start>=n || s.charAt(start) == '0' )
        {
            return 0;
        }
        if(dp[start] != -1)
        {
            return dp[start];
        }
         int ways = 0;
         ways += decode(s,n,start+1,dp);

        if(start+1>=n)
        {
            dp[start] = ways;
            return dp[start];
        }

        int num = (((s.charAt(start)-'0')*10) + (s.charAt(start+1)-'0')) ;

        if(num>=10 && num <= 26)
        {
            ways += decode(s,n,start+2,dp);
        }
        
        dp[start] = ways;
        return dp[start];
    }
}