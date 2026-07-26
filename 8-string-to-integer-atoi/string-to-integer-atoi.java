class Solution {
    public int myAtoi(String s) {
        s= s.trim();
        int n = s.length();
        if(n==0)
        {
            return 0;
        }
        double count = 0;
        int sign = 1;
        int i =0;
        if(s.charAt(0) == '-')
        {
            sign =-1;
            i=1;
        }
        else if(s.charAt(0) == '+')
        {
            i=1;
        }
        
        count = findVal(s,n,i,0,sign);
        if(count == Math.pow(2,31))
        {
            return Integer.MIN_VALUE;
        }
        count = count *sign;
        return (int)count;
    }
    public double  findVal(String s, int n, int i,int val,int sign)
    {
        if(i == n )
        {
            return val;
        }
        char ch = s.charAt(i);

        if(!Character.isDigit(ch))
        {
            return val;
        }
        int num = ch-'0';
       
        if(val>(Integer.MAX_VALUE-num)/10)
        {
            return sign==1?Integer.MAX_VALUE:Math.pow(2,31);
        }
        val = val*10+num;

        return findVal(s,n,i+1,val,sign);
    }
}