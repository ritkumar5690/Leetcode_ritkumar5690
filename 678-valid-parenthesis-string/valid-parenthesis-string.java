class Solution {
    private int n;
    private Boolean dp[][];
    public boolean checkValidString(String s) {
        n = s.length();
        dp = new Boolean[n+1][n+1];
        
        return solve(s,0,0,0);
    }
    private boolean solve(String s,int i,int open,int close){
        if(i == n){
            return open==close;
        }
        if(close>open){
            return false;
        }
        if(dp[i][open-close] !=null){
            return dp[i][open-close];
        }
        char ch = s.charAt(i);
        
        if(ch == '('){
           return dp[i][open-close] = solve(s,i+1,open+1,close);
        }
        if(ch == ')'){
            return dp[i][open-close] =solve(s,i+1,open,close+1);
        }
        
        return dp[i][open-close]= solve(s,i+1,open+1,close) || solve(s,i+1,open,close+1) || solve(s,i+1,open,close);
    }
}