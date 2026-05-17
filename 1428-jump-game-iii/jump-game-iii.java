class Solution {
    public boolean canReach(int[] arr, int start) {
        int n = arr.length;
        if (n == 1 && arr[0] == 0)
            return true;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return (findPath(arr, start - arr[start], n, start, start,dp) || findPath(arr, start + arr[start], n, start,start, dp));
    }

    public boolean findPath(int[] arr, int idx, int n, int start,int parSt, int[] dp) {
        if (idx < 0 || idx >= n) {
            return false;
        }
        if (arr[idx] == 0)
            return true;
        if (idx == start || dp[idx] == 0) {
            dp[idx] = 2;
            return false;
        }
        if (dp[idx] == 1)
            return true;
        else if (dp[idx] == 2)
            return false;
        dp[idx] = 0;
        boolean val1 = findPath(arr, idx - arr[idx], n, start,idx, dp);
        boolean val2 = findPath(arr, idx + arr[idx], n, start,idx, dp);
        if((val1 || val2) == true) return true;
        dp[idx] = 2;
        return false;
    }
}