class Solution {
    public double champagneTower(int poured, int query_row, int query_glass) {

        double[][] dp = new double[query_row + 1][query_row + 1];

        // All poured champagne starts at the top
        dp[0][0] = poured;

        for (int row = 0; row < query_row; row++) {

            for (int col = 0; col <= row; col++) {

                // Only champagne above 1 can overflow
                double overflow = Math.max(0, dp[row][col] - 1);

                // Half goes to left child
                dp[row + 1][col] += overflow / 2;

                // Half goes to right child
                dp[row + 1][col + 1] += overflow / 2;
            }
        }

        // A glass can hold at most 1
        return Math.min(1, dp[query_row][query_glass]);
    }
}