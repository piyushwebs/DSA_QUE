class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;

        int[] prefixSum = new int[n];
        int ans = 0;

        for(int i=0;i<n;i++)
        {
            prefixSum[i] = i==0?nums[i]:prefixSum[i-1]+nums[i];

            if(prefixSum[i] == k) ans++;
        }

        for(int i=0;i<n;i++)
        {
            for(int j=i+1;j<n;j++)
            {
                if((prefixSum[j]-prefixSum[i]) == k)
                {
                    ans++;
                }
            }
        }
        
        return ans;
    }
}