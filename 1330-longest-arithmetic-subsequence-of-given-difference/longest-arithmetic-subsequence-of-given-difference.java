class Solution {
    public int longestSubsequence(int[] arr, int difference) {
        int n = arr.length;
        int[] dp = new int[n];
        HashMap<Integer,Integer> hm = new HashMap<>();

        Arrays.fill(dp,1);
        int ans = 1;
        hm.put(arr[n-1],n-1);
        for(int i=n-2;i>=0;i--)
        {
            if(hm.containsKey(arr[i]+difference))
            {
                dp[i] = dp[i]+dp[hm.get(arr[i]+difference)];
                ans = Math.max(ans,dp[i]);
            }
            hm.put(arr[i],i);
        }
        return ans;
    }
}