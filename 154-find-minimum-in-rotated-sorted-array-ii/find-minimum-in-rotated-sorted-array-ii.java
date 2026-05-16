class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        int left = 0;
        int right = n-1;
        if(nums[left]<nums[right]) return nums[0];
        while(left<right)
        {
            int mid= left+(right-left)/2;
            if(mid!=0 && nums[mid]<nums[mid-1]) return nums[mid];
            else if(nums[mid]>nums[right]) left = mid+1;
            else if(nums[mid]<nums[right]) right = mid-1;
            else right--;
        }
        return nums[left];
    }
}