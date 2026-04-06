class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        int n = nums.length;
        for(int i=0;i<n;i++)
        {
          if(!hm.isEmpty() && hm.containsKey(target-nums[i]))
          {
            return new int[] {i,hm.get(target-nums[i])};
          }
          hm.put(nums[i],i);
        }
        return new int[] {-1,-1};
    }
}