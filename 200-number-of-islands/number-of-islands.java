class Solution {
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        int ans = 0;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
              if(grid[i][j]=='1' && !visited[i][j])
              {
                visited[i][j]=true;
                ans++;
                markVisForOne(grid,i,j+1,visited,n,m);
                markVisForOne(grid,i+1,j,visited,n,m);
                markVisForOne(grid,i,j-1,visited,n,m);
                markVisForOne(grid,i-1,j,visited,n,m);
              }
            }
        }
        return ans;
    }
    public void markVisForOne(char[][] grid,int i,int j,boolean[][] visited,int n,int m)
    {
       if(i<0 || j<0 || i==n || j==m || visited[i][j] || grid[i][j] == '0') return ;
       visited[i][j] = true;
       markVisForOne(grid,i,j+1,visited,n,m);
       markVisForOne(grid,i+1,j,visited,n,m);
       markVisForOne(grid,i,j-1,visited,n,m);
       markVisForOne(grid,i-1,j,visited,n,m);
       return;
    }
}