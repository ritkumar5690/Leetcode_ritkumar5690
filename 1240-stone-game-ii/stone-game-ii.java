class Solution {
    int n;
    int dp[][][];

    public int stoneGameII(int[] piles) {
        n = piles.length;
        dp = new int[2][101][101];

        for (int[][] row2D : dp) {
            for (int[] row1D : row2D) {
                Arrays.fill(row1D, -1);
            }
        }
        return solveAlice(0, 1, 0, piles);
    }

    private int solveAlice(int person, int m, int i, int[] piles) {
        if (i >= n)
            return 0;
        int stone = 0;
        if (dp[person][i][m] != -1) {
            return dp[person][i][m];
        }
        int res = (person == 0) ? -1 : Integer.MAX_VALUE;
        for (int x = 1; x <= Math.min(2 * m, n - i); x++) {
            stone += piles[i + x - 1];
            if (person == 0) {
                res = Math.max(res, stone + solveAlice(1, Math.max(x, m), i + x, piles));
            } else {
                res = Math.min(res, solveAlice(0, Math.max(x, m), i + x, piles));
            }
        }
        return dp[person][i][m] = res;
    }
}