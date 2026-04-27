class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int i = 0;
        
        int max = Integer.MIN_VALUE;
        int ans = 0;
        int currEnd = 0;
        while(i<n-1)
        {
            max = Math.max(max,i+nums[i]);
            if(i==currEnd)
            {
                currEnd = max;
                ans++;
            }
            i++;
        }
        return ans;
    }
}