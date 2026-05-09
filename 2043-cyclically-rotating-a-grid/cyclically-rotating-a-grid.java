class Solution {
    public int[][] rotateGrid(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] ans = new int[n][m];
        int half = Math.min(m,n)/2;
        int i=0;
        while(i<half)
        {
           ArrayList<Integer> arr = new ArrayList<>();
           for(int j = i;j<m-i;j++)
           {
             arr.add(grid[i][j]);
           }
           for(int j=i+1;j<n-i;j++)
           {
            arr.add(grid[j][m-i-1]);
           }
           for(int j=m-i-2;j>=i;j--)
           {
            arr.add(grid[n-i-1][j]);
           }
           for(int j=n-i-2;j>i;j--)
           {
            arr.add(grid[j][i]);
           }
           rotateList(arr,k%arr.size());
         
           // adding back to 2D array.
           for(int j = i;j<m-i;j++)
           {
             ans[i][j] = arr.remove(0);
           }
           for(int j=i+1;j<n-i;j++)
           {
            ans[j][m-i-1] = arr.remove(0);
           }
           for(int j=m-i-2;j>=i;j--)
           {
            ans[n-i-1][j] = arr.remove(0);
           }
           for(int j=n-i-2;j>i;j--)
           {
            ans[j][i] = arr.remove(0);
           }
           i++;
        }
        return ans;
    }
    public void rotateList(ArrayList<Integer> arr, int k)
    {
        if(arr.size() == 0) return;
        for(int i=0;i<k;i++)
        {
            int val = arr.remove(0);
            arr.add(val);
        }
    }
}