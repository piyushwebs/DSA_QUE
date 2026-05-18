class Solution {
    public int climbStairs(int n) {
        int val1 = 1;
        int val2 = 2;
        if(n<=2) return n;
        int val3 = 0;
        for(int i=2;i<n;i++)
        {
            val3 = val1+val2;
            val1 = val2;
            val2 = val3;
        }
        return val3;
    }
}