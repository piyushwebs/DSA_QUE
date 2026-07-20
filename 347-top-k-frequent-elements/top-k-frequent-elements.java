class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;
        
        HashMap<Integer,Integer> hm = new HashMap<>();

        int[] ans = new int[k];

        for(int i=0;i<n;i++)
        {
            hm.put(nums[i],hm.getOrDefault(nums[i],0)+1);
        }

        int[][] arr = new int[hm.size()][2];

        Set<Integer> st = hm.keySet();
        
        int idx = 0;

        for(int val : st)
        {
            arr[idx][0] = val;
            arr[idx++][1] = hm.get(val);
        }
        
        Arrays.sort(arr,(a,b)->Integer.compare(b[1],a[1]));

        for(int i=0;i<k;i++)
        {
            ans[i] = arr[i][0];
        }

        return ans;

    }
}