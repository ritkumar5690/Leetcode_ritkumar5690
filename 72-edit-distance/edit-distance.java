class Solution {
    private int n;
    private int m;
    private int[][] dp;

    public int minDistance(String word1, String word2) {
        n = word1.length();
        m = word2.length();
        dp = new int[n][m];

        for(int i[]:dp){
            Arrays.fill(i,-1);
        }

        return solve(word1,word2,0,0);
    }
    private int solve(String s,String t,int i,int j){
        if(i== n ){
            return m-j;
        }
        if (j == m) {
            return n - i;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        if(s.charAt(i) == t.charAt(j)){
            return dp[i][j] = solve(s,t,i+1,j+1);
        }
        
        int replace = 1+solve(s,t,i+1,j+1);
        int insert = 1+solve(s,t,i,j+1);
        int delete = 1+solve(s,t,i+1,j);
        
        return dp[i][j] = Math.min(replace,Math.min(insert,delete));
    }
}
