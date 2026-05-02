class Solution {
    public int rotatedDigits(int n) {
        if(n==1 || n==2 )
        {
            return n-1;
        }
        int count = 0;
        for(int i = 1 ; i <= n ; i++)
        {
            if(checkValid(i)) count++;
        }
        return count;
    }
    public boolean checkValid(int n)
    {
        if( n == 2 || n == 5 || n == 6 || n == 9 )
        {
            return true;
        }
        else if( n==1 || n== 3||n==4||n==7||n==8||n==10) return false;
        int temp = n;
        int c = 0;
        while( temp > 0)
        {
           int rem = temp%10;
           if(rem != 2 && rem != 5 && rem != 6 && rem != 9 && rem != 0 && rem != 1 && rem != 8)
           {
            return false;
           }
           if( rem == 2 || rem == 5 || rem == 6 || rem == 9)
           {
            c++;
           }
           temp = temp/10;
        }
        return c>0 ? true : false;
    }
}