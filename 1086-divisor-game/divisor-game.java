class Solution {
    public boolean divisorGame(int n) {
        if(n<=1) return false;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return playChance(n, 0, true, dp);
    }

    public boolean playChance(int n, int p, boolean val, int[] dp) {
        
        for (int i = 1; i < n; i++) {
            if (n % i == 0) {
               return  !playChance(n - i, p + 1, val, dp);
            }
        }
        return false;
    }
}