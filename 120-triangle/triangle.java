class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int rows = triangle.size();
        int[][] dp = new int[rows][rows];
        for(int[] row: dp)
        {
            Arrays.fill(row,Integer.MIN_VALUE);
        }
        return findMinTotal(triangle,0,rows,0,dp);
    }
    public int findMinTotal(List<List<Integer>> triangle,int idx,int row,int col,int[][] dp)
    {
        if(idx == row) return 0;
        if(dp[idx][col]!=Integer.MIN_VALUE) return dp[idx][col];
        List<Integer> arr = triangle.get(idx);
        int val = arr.get(col);
        dp[idx][col] = Math.min(findMinTotal(triangle,idx+1,row,col,dp),findMinTotal(triangle,idx+1,row,col+1,dp))+val; 
        return dp[idx][col];
    }
}