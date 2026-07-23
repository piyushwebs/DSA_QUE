class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        int[][] dp = new int[n][m];
        boolean[][] visited = new boolean[n][m];

        Queue<int[]> q = new LinkedList<>();

        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(mat[i][j] == 0)
                {
                    q.offer(new int[]{i,j});
                    dp[i][j] = 0;
                }
                else
                {
                    dp[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        while(!q.isEmpty())
        {
            int[] arr = q.poll();
            
            int[][] a = {{1,0},{0,1},{-1,0},{0,-1}};
            for(int i=0;i<4;i++)
            {
               int[] b = a[i];
               int idx = arr[0]+b[0];
               int idx1 = arr[1]+b[1];

               if(idx>=0 && idx1>=0 && idx<n && idx1<m)
               {
                if(dp[idx][idx1]>(dp[arr[0]][arr[1]]+1))
                {
                    dp[idx][idx1] = dp[arr[0]][arr[1]]+1;
                    q.offer(new int[]{idx,idx1});
                }
               }
            }
        }
        return dp;
    }
}