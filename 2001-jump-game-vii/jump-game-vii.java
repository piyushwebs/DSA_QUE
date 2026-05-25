class Solution {
    public boolean canReach(String s, int minJump, int maxJump) {

        int n = s.length();

        // last position must be 0
        if (s.charAt(n - 1) != '0') return false;

        boolean[] dp = new boolean[n];
        dp[0] = true;

        int reachable = 0;

        for (int i = 1; i < n; i++) {

            // add new index entering window
            if (i - minJump >= 0 && dp[i - minJump]) {
                reachable++;
            }

            // remove old index leaving window
            if (i - maxJump - 1 >= 0 && dp[i - maxJump - 1]) {
                reachable--;
            }

            // current index reachable?
            dp[i] = reachable > 0 && s.charAt(i) == '0';
        }

        return dp[n - 1];
    }
}