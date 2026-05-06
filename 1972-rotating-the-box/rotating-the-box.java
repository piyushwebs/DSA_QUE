class Solution {
    public char[][] rotateTheBox(char[][] boxGrid) {
        int m = boxGrid.length;
        int n = boxGrid[0].length;  
        char[][] ans = new char[n][m];
        int i = 0;
        while(i<m)
        {
            int j = n-1;
            int k = n-1;
            while(j>=0)
            {
                if(k==-1) break;
                if(boxGrid[i][j] == '#')
                {
                   ans[k][m-i-1] = '#';
                    k--;
                }
                else if(boxGrid[i][j] == '*')
                {
                    ans[j][m-i-1] = '*';
                    k = j-1;
                }
                j--;
            }
            i++;
        }
        for(int l=0;l<n;l++)
        {
            for(int j=0;j<m;j++)
            {
                if(ans[l][j] != '*' && ans[l][j] != '#')
                {
                    ans[l][j] = '.';
                }
            }
        }
        return ans;
    }
}