class Solution {
    public int getCommon(int[] nums1, int[] nums2) {
        int i = 0;
        int j = 0;
        int n = nums1.length;
        int m = nums2.length;
        while(i<n && j<m)
        {
            while(i<n && nums1[i]<nums2[j])
            {
                i++;
            }
            if(i==n) return -1;
            if(nums1[i] == nums2[j])
            {
                return nums1[i];
            }
            if(j==n) return -1;
            while(j<m && nums2[j]<nums1[i])
            {
                j++;
            }
        }
        return -1;
    }
}