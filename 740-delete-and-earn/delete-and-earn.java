class Solution {
    public int deleteAndEarn(int[] nums) {
        TreeMap<Integer,Integer> tm = new TreeMap<>();
        int n = nums.length;
        for(int i=0;i<n;i++)
        {
            tm.put(nums[i],tm.getOrDefault(nums[i],0)+1);
        }
        int[] dp = new int[n];
        int[] arr = new int[n];
        int j=0;
        for(int st : tm.keySet())
        {
            arr[j] = st;
            j++;
        }
        Arrays.fill(dp,-1);
        return formMax(dp,arr,tm,tm.size(),0);
    }

    public int formMax(int[] dp,int[] arr,TreeMap<Integer,Integer> tm,int n, int idx)
    {
        if(idx >= n)
        {
            return 0;
        }
        if(dp[idx]!=-1)
        {
            return dp[idx];
        }
        if(!tm.containsKey(arr[idx]+1))
        {
            dp[idx] = Math.max(dp[idx],(formMax(dp,arr,tm,n,idx+1)+(tm.get(arr[idx])*arr[idx])));
        }
        else 
        {
            int temp = Math.max((formMax(dp,arr,tm,n,idx+1)),(formMax(dp,arr,tm,n,idx+2)+tm.get(arr[idx])*arr[idx]));

            dp[idx] = Math.max(dp[idx],temp);

        }
        return dp[idx];
    }

}