class Solution {
    int n;
    int n2;
    int[][] dp;

    public int numDistinct(String s, String t) {
        n = s.length();
        n2 = t.length();

        dp = new int[n][n2];
        for (int[] i : dp) {
            Arrays.fill(i, -1);
        }
        return solve(s, t, 0, 0);
    }

    private int solve(String s, String t, int i, int j) {
        if (j == n2) {
            return 1;
        }
        if (i == n) {
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        int take = 0;
        if (s.charAt(i) == t.charAt(j)) {
            take = solve(s, t, i + 1, j + 1);
        }
        int skip = solve(s, t, i + 1, j);
        return dp[i][j] = take + skip;

    }
}