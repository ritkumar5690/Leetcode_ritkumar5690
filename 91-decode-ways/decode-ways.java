class Solution {
    private int dp[];
    private int n ;
    public int numDecodings(String s) {
        n = s.length();
        dp = new int[n+1];
        Arrays.fill(dp,-1);
        return solve(s,0);
    }
    private int solve(String s , int i){
        if(i == n){
            return 1;
        }
        if(s.charAt(i) == '0'){
           return 0;
        }
        if(dp[i] !=-1){
            return dp[i];
        } 
        int first = solve(s,i+1);
        if(i+1<n){
            int num =Integer.parseInt(s.substring(i,i+2));
            if(num >=10 && num<=26){
                first += solve(s,i+2);
            }
        }
        return dp[i] = first;
    }
}
