class Solution {
    Boolean dp[];
    public boolean winnerSquareGame(int n) {
        dp = new Boolean[n+1];
        return solveAlice(n);

    }
    private boolean solveAlice(int n){
        if(n == 0) return false;
        if(dp[n] != null){
            return dp[n];
        }

        for(int x = 1; x*x<=n;x++){
            int rem = n-(x*x);
            if(!solveAlice(rem)){
                return dp[n] = true;
            }
        }
        return dp[n] = false;

    }
}