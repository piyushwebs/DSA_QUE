class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int left = 0;
        int right = n-1;
        while(left<=right)
        {
            int mid = left+(right-left)/2;
            if(nums[mid]== target) return mid;
            System.out.println(mid);
            if(target>nums[mid])
            {
                if(target<=nums[right] || nums[mid]>nums[right])
                {
                    left= mid+1;
                }
                else
                {
                    right = mid-1;
                }
            }
            else
            {
                if(target>=nums[left] || nums[mid]<nums[left])
                {
                    right = mid-1;
                }
                else
                {
                    
                    left = mid+1;
                }
            }
        }
        return -1;
    }
}