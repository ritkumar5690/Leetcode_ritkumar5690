class Solution {
    private int n;
    private int m;
    private Boolean dp[][];
    public boolean isMatch(String s, String p) {
        n = s.length();
        m = p.length();
        dp = new Boolean[n+1][m+1];
        return solve(s,p,0,0);
    }
    private boolean solve(String s,String p,int i,int j){
        if (j == m) {
            return i == n;
        }
        if(dp[i][j]!=null){
            return dp[i][j];
        }
        boolean firstMatch = i < n && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');
        boolean res = false ;         
        if (j + 1 < m && p.charAt(j + 1) == '*'){
            boolean skip = solve(s, p, i, j + 2);
            boolean take =firstMatch && solve(s, p, i+1, j );
            res = skip || take;
        }
        
        else{
            res = firstMatch && solve(s, p, i + 1, j + 1);
        }
        return dp[i][j] = res;
    }
}
