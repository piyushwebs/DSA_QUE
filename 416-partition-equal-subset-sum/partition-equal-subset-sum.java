class Solution {
    public boolean canPartition(int[] nums) {
        int sum = totalSum(nums);
        if(sum%2!=0 || nums.length==1) return false;
        int halfSum = sum/2;
        Boolean[][] dp = new Boolean[nums.length][halfSum+1];
        return checkSum(nums,0,halfSum,0,dp);
    }
    public boolean checkSum(int[] nums,int i,int ActSum,int currSum,Boolean[][] dp)
    {
        if(currSum>ActSum || i>=nums.length) return false;
        if(dp[i][currSum]!=null) return dp[i][currSum];
        if(currSum == ActSum) return true;
        if(!checkSum(nums,i+1,ActSum,currSum+nums[i],dp))
        {
            dp[i][currSum] = checkSum(nums,i+1,ActSum,currSum,dp);
            return dp[i][currSum];
        }
        dp[i][currSum] = true;
            return true;
    }
    public int totalSum(int[] nums)
    {
        int sum = 0;
        for(int val:nums)
        {
          sum+=val;
        }
        return sum;
    }
}