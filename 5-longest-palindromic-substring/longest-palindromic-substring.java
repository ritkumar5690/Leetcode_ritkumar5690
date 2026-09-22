class Solution {
    
    private int[][] dp;
    private int start = 0;
    private int maxLen = 1;
    public String longestPalindrome(String s) {
        int n = s.length();
        dp = new int[n+1][n+1];
        for(int[] i: dp){
            Arrays.fill(i,-1);
        }

        solve(s, 0, n - 1);

        return s.substring(start, start + maxLen);

        
    }
    private int solve(String s,int i,int j){
        if(i >= j ){
            return 1;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        int inner = solve(s,i+1,j-1);

        if(s.charAt(i) == s.charAt(j) && inner ==1){
            int curr = j-i+1;
            if(maxLen < curr){
                start = i;
                maxLen = curr;
            }
            dp[i][j] = 1;
            return 1;
            
        }
        solve(s,i+1,j);
        solve(s,i,j-1);
        return dp[i][j] = 0;
         
    }
}
