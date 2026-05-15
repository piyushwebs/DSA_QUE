class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        int left = 0;
        int right = n-1;
        if(nums[right]>nums[left]) return nums[0];
        while(left<right)
        {
            int mid = left+(right-left)/2;
            if(mid!=0 && nums[mid-1]>nums[mid]) return nums[mid];
            else if(nums[0]>nums[mid]) right = mid-1;
            else left = mid+1;
        }
        return nums[left];
    }
}