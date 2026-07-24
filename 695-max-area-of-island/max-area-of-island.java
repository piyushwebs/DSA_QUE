class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int ans = 0;
        boolean[][] visited = new boolean[n][m];

        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(!visited[i][j])
                {
                   visited[i][j] = true;
                   if(grid[i][j] != 0)
                   {
                    int count = 1;
                    int[][] arr = {{1,0},{-1,0},{0,1},{0,-1}};


                    for(int k=0;k<arr.length;k++)
                    {
                       int val = findMaxArea(visited,grid,i+arr[k][0],j+arr[k][1],arr);
                       count += val;
                    }
                    ans = Math.max(ans,count);
                   }
                }
            }
        }
        
        return ans;
    }

    public int findMaxArea(boolean[][] visited,int[][] grid,int i, int j,int[][] arr)
    {
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length)
        {
            return 0;
        }
       

        if(visited[i][j] || (grid[i][j] == 0))
        {
            visited[i][j] = true;
            return 0;
        }

        visited[i][j] = true;
         
         int val = 0;
        for(int l=0;l<arr.length;l++)
        {
            val += findMaxArea(visited,grid,i+arr[l][0],j+arr[l][1],arr);
        }
        return val+1;
    }
}