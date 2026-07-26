class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        int n = nums.length;
        int idx = 0;
        for(int val:nums)
        {
          if(!hm.isEmpty() && hm.containsKey(target-val))
          {
            return new int[] {idx,hm.get(target-val)};
          }
          hm.put(val,idx);
          idx++;
        }
        return new int[] {-1,-1};
    }
}