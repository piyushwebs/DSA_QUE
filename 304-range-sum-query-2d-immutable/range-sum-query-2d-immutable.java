class NumMatrix {
     int[][] prefixSum;
    public void formMatrix(int[][] matrix)
    {
        int row = matrix.length;
        int col = matrix[0].length;

       prefixSum = new int[row][col];

        for(int i=0;i<row;i++)
        {
            for(int j=0;j<col;j++)
            {
                if(i==0)
                {
                    prefixSum[i][j] = matrix[i][j]+(j==0?0:prefixSum[i][j-1]);
                }
                else if(j==0)
                {
                    prefixSum[i][j] = matrix[i][j]+(i==0?0:prefixSum[i-1][j]);
                }
                else
                {
                    prefixSum[i][j] = matrix[i][j] - (prefixSum[i-1][j-1])+prefixSum[i-1][j]+prefixSum[i][j-1];
                }
            }
        }
    }
    public NumMatrix(int[][] matrix) {
        formMatrix(matrix);

    }
   
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int ans = 0;
        if(row1 !=0 && col1 !=0)
        {
           return (prefixSum[row2][col2]-prefixSum[row1-1][col2])-(
            prefixSum[row2][col1-1]-prefixSum[row1-1][col1-1]);
        }
        else if(row1 == 0 && col1 == 0)
        {
               return (prefixSum[row2][col2]-0)-(0);
        }
        else if(row1 == 0)
        {
               return (prefixSum[row2][col2]-0)-(
            prefixSum[row2][col1-1]-0);
        }
         return (prefixSum[row2][col2]-prefixSum[row1-1][col2])-(0);
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */