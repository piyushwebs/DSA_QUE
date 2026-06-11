class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int n = nums.length;
        int ans = Integer.MAX_VALUE;
        int minDiff = Integer.MAX_VALUE;
        Arrays.sort(nums);
        // Brute force approach but gives time limit exceed 
        // for(int i=0;i<n;i++)
        // {
        //     for(int j=i+1;j<n;j++)
        //     {
        //         for(int k=j+1;k<n;k++)
        //         {
        //             int sum = nums[i]+nums[j]+nums[k];
                   
        //                 if(minDiff>(Math.abs(target-sum)))
        //                 {
        //                     ans = sum;
        //                     minDiff = Math.abs(target-sum);
        //                 }
                    
        //         }
        //     }
        // }
        for(int i=0;i<n-2;i++)
    {
        int left = i+1;
        int right = n-1;
        while(left<right)
        {
            int sum = nums[left]+nums[i]+nums[right];
            if(minDiff>(Math.abs(target-sum)))
            {
                ans = sum;
                minDiff = Math.abs(target-sum);
            }
            
            if(sum>target)
            {
                right--;
            }
            else if(sum<target)
            {
                left++;
            }
            else
            {
                return ans;
            }
           }
              }
        return ans;
    }
}