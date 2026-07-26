class Solution {
    public int reverse(int x) {
      
        int sign = 1;
        if(x<0)
        {
            x = x*-1;
            sign = -1;
        }

        if(x == Integer.MIN_VALUE ||  x==Integer.MAX_VALUE)
        {
            return 0;
        }

        int ans = 0;
        
        boolean flag = false;

        StringBuilder str = new StringBuilder("");

        int limit = Integer.MAX_VALUE;

        if(x==0)
        {
                return 0;
        }

        while(x!=0)
        {
            while(!flag &&  x!=0 && x%10 == 0)
            {
                x = x/10;
                
            }
            flag = true;
            
            int val = x%10;
            if(val<0)
            {
                val = val*-1;
            }
            str.append(val);
            x = x/10;
        }
        
        long val = Long.parseLong(str.toString());
        if(val>limit || val<Integer.MIN_VALUE)
        {
            return 0;
        }
        ans = (int)val;
       return ans*sign;
    }
}