class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (a, b) -> Integer.compare(a[0], b[0]));
        int n = pairs.length;
        Integer[][] memo = new Integer[n + 1][n + 1];
        return solve(pairs, 0, -1, memo);
    }

    private int solve(int[][] pairs, int idx, int prevIdx, Integer[][] memo) {
        if (idx == pairs.length) return 0;

        if (memo[idx][prevIdx + 1] != null) return memo[idx][prevIdx + 1];

        int skip = solve(pairs, idx + 1, prevIdx, memo);

        int take = 0;
        if (prevIdx == -1 || pairs[idx][0] > pairs[prevIdx][1]) {
            take = 1 + solve(pairs, idx + 1, idx, memo);
        }

        int ans = Math.max(skip, take);
        memo[idx][prevIdx + 1] = ans;
        return ans;
    }
}