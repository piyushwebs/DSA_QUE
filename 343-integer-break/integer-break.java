class Solution {
    public int integerBreak(int n) {
        int ans = Integer.MIN_VALUE;
        int part = 2;
        while(part <= n)
        {
            
            int val = n/part;
            int rem = 0;
            if(val*part != n)
            {
               rem = n-(val*part);
            }
            int i=1;
            int mul = 1;
            while(i<=part)
            {
              while(rem>0)
              {
                 mul*=(val+1);
                 rem--;
                 i++;
              }
              mul*=val;
              i++;
            }
            ans = Math.max(ans,mul);
            part++;
        }
        return ans;
    }
}