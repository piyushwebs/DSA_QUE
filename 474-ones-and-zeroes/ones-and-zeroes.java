class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] count = new int[strs.length][2];
        for(int i=0;i<strs.length;i++)
        {
           for(char ch:strs[i].toCharArray())
           {
            if(ch=='0')
            {
                count[i][0]++;
            }
            else
            {
                count[i][1]++;
            }
           }
        }
        int[][][] dp = new int[strs.length][m+1][n+1];
        for(int i=0;i<strs.length;i++)
        {
            for(int j=0;j<m+1;j++)
            {
                Arrays.fill(dp[i][j],-1);
            }
        }
        return findLongestSub(count,strs.length,m,n,0,dp);
    }
    public int findLongestSub(int[][] count,int size,int m,int n,int idx,int[][][] dp)
    {
        
        if(size == idx)
        {
            return 0;
        }
        if(dp[idx][m][n] != -1)
        {
          return dp[idx][m][n];
        }
        
        
        int skip =findLongestSub(count,size,m,n,idx+1,dp);
        int take = 0;
        if((m-count[idx][0]>=0) && (n-count[idx][1]>=0))
        {
            take = take + 1 + findLongestSub(count,size,m-count[idx][0],n-count[idx][1],idx+1,dp);
        }
        return dp[idx][m][n] = Math.max(skip,take);
    }
}