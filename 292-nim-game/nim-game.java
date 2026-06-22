class Solution {
    public boolean canWinNim(int n) {
        return n%4==0?false:true;
        // if(n<=3) return true;
        // int[] dp = new int[n];
        // int[] dp1 = new int[n];
        // Arrays.fill(dp,-1);
        // return canWin(n-1,false,dp)||canWin(n-2,false,dp)||canWin(n-3,false,dp);
    }
    public boolean canWin(int n,boolean turn,int[] dp)
    {
        
        if(n<=3)
        {
            return turn;
        }
        if(!turn)
        {
             turn = true;
             if(canWin(n-1,turn,dp)&&canWin(n-2,turn,dp)&&canWin(n-3,turn,dp))
             {
                dp[n]=0;
             }
             else
             {
                dp[n]=2;
             }
             return dp[n]==0?true:false;
        }
        else
        {
             if(canWin(n-1,false,dp)||canWin(n-2,false,dp)||canWin(n-3,false,dp))
             {
                dp[n]=0;
             }
             else
             {
                dp[n]=1;
             }
             return dp[n]==0?true:false;
        }
    }
}