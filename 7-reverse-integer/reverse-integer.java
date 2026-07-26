class Solution {
    public int reverse(int x) {
       
        
        int ans = 0;
        int digit = 0;
        while(x!=0)
        {
            int val = x%10;
            
            if((ans>Integer.MAX_VALUE/10)||(ans<Integer.MIN_VALUE/10)||(ans==Integer.MAX_VALUE/10 && val>7) || (ans==Integer.MIN_VALUE/10 && val<-8))
            {
                return 0;
            }
            ans = ans*10+val;
            x = x/10;
        }
       return ans;
    }
}