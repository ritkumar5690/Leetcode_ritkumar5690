class Solution {
    private int n;
    private int m;
    private Boolean dp[][];
    public boolean isInterleave(String s1, String s2, String s3) {
        n = s1.length();
        m = s2.length();
        
        dp = new Boolean[n+1][m+1];
        if(m+n < s3.length()) return false;
        
        return solve(s1,s2,s3,0,0);
    }
    private boolean solve(String s1, String s2, String s3,int i,int j){
        if(j == m && i==n){
            return true;
        }
        
        int k = i+j;
        if(k>= s3.length()){
            return false;
        }
        if(dp[i][j] != null){
            return dp[i][j]; 
        }
        boolean first = false;
        boolean second = false;
        if(i<n &&  s1.charAt(i) == s3.charAt(k)){
          first = solve(s1,s2,s3,i+1,j);
        }
        if(j<m && s2.charAt(j) == s3.charAt(k)){
            second = solve(s1,s2,s3,i,j+1);
        }
        return dp[i][j] = (first || second);
    }
}
