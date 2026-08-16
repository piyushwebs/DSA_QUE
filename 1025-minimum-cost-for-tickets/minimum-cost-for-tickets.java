class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int n=days.length;
        int[] dp = new int[n];
        dp[n-1] = Math.min(costs[0],Math.min(costs[1],costs[2]));
        for(int i=n-2;i>=0;i--)
        {
            int val1 = costs[0]+dp[i+1];
            int skip7 = days[i]+7;
            int j = i;
            while(j<n && skip7>days[j])
            {
                j++;
            }
           
            int val7 = j==n?(costs[1]):(costs[1]+dp[j]);
             j = i;
            int skip30 = days[i]+30;
            while(j<n && skip30>days[j])
            {
                j++;
            }
            int val30 = j==n?(costs[2]):(costs[2]+dp[j]);

            dp[i] = Math.min(val1,Math.min(val7,val30));
        }
        return dp[0];
    }
}