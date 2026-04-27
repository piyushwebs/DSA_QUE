class Solution {
    public long minOperations(int[] nums) {
        int n = nums.length;
        if(n==1)
        {
            return 0;
        }
        int i=1;
        long ans = 0;
        while(i<n)
        {
            if(nums[i]<nums[i-1])
            {
              int max = nums[i-1];
              int min =nums[i];
              ans += max-min;
              i++;
              while(i<n && nums[i]>nums[i-1])
              {
                i++;
              }
              if(i==n)
              {
                return ans;
              }
            }
            else
            {
                i++;
            }
        }
        return ans;
    }
}