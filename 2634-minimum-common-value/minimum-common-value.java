class Solution {
    public int getCommon(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int val:nums1)
        {
            hm.put(val,hm.getOrDefault(val,0)+1);
        }
        int min = Integer.MAX_VALUE;
        for(int val1:nums2)
        {
           if(hm.containsKey(val1))
           {
            min = Math.min(min,val1);
           }
        }
        return min == Integer.MAX_VALUE?-1:min;
    }
}