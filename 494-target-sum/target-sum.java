class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        return numWays(nums,target,n,0,0,0);
    }
    public int numWays(int[] nums,int target,int n,int sum,int idx,int total)
    {
        if(idx == n )
        {
            return sum==target?1:0;
        }
       
        int minus = numWays(nums,target,n,sum-(nums[idx]),idx+1,total);
        int plus = numWays(nums,target,n,sum+nums[idx],idx+1,total);
        
        return minus+plus;
    }
}