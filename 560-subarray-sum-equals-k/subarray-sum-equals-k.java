class Solution {
    public int subarraySum(int[] nums, int k) {

        HashMap<Integer, Integer> hm = new HashMap<>();

        // Prefix sum 0 has occurred once (before the array starts)
        hm.put(0, 1);

        int prefix = 0;
        int ans = 0;

        for (int num : nums) {

            // Update current prefix sum
            prefix += num;

            // Check if there exists a previous prefix
            // such that prefix - previousPrefix = k
            if (hm.containsKey(prefix - k)) {
                ans += hm.get(prefix - k);
            }

            // Store current prefix sum
            hm.put(prefix, hm.getOrDefault(prefix, 0) + 1);
        }

        return ans;
    }
}