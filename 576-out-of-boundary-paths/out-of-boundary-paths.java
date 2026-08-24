class Solution {
    int MOD = (int)Math.pow(10,9)+7;
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        int row = startRow;
        int col = startColumn;
        int[][][] dp = new int[m][n][maxMove+1];
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                Arrays.fill(dp[i][j],-1);
            }
        }
        return maximumPath(m,n,row,col,dp,maxMove)%MOD;
    }
    public int maximumPath(int m,int n,int row,int col,int[][][] dp,int maxMove)
    {
        if(row==m || row<0 || col<0 || col==n)
        {
            return 1;
        }
        if(dp[row][col][maxMove]!=-1)
        {
            return dp[row][col][maxMove];
        }
        if(maxMove==0)
        {
            dp[row][col][maxMove] = 0;
            return 0;
        }
        long left = maximumPath(m,n,row-1,col,dp,maxMove-1);
        long right = maximumPath(m,n,row+1,col,dp,maxMove-1);
        long up = maximumPath(m,n,row,col-1,dp,maxMove-1);
        long down = maximumPath(m,n,row,col+1,dp,maxMove-1);
        return dp[row][col][maxMove] = (int)((left+right+up+down)%MOD);
    }
}