class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int ans = Integer.MIN_VALUE;
        int[] arr =  new int[n];
        Arrays.fill(arr,0);
        for(int i=n-1;i>=0;i--)
        {
           for(int j=i+1;j<n;j++)
           {
            if(nums[i]<nums[j])
            {
               arr[i] = Math.max(arr[i],arr[j]);
            }
           }
           arr[i]++;
        }
        for(int val:arr)
        {
            ans = Math.max(ans,val);
        }
        return ans;
    }
}