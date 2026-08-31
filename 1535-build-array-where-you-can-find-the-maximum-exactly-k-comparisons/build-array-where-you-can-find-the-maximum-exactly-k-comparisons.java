class Solution {
    private static final int MOD = 1_000_000_007;
    int t[][][];
    public int numOfArrays(int n, int m, int k) {
        if(n < k || m < k){
            return 0;
        }
        t = new int[n+1][k+1][m+1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= k; j++) {
                Arrays.fill(t[i][j], -1);
            }
        }
        return solve(n,m,k,0,0,0);
    }
    private int solve(int n,int m,int k, int index, int cost, int max){
        if(index == n ){
            return cost == k ? 1:0;
        }
        if(t[index][cost][max] !=-1){
            return t[index][cost][max];
        }
        long ans = 0;
        for(int j = 1;j<=m;j++){
            if(max < j){
                if(cost < k){
                    ans += solve(n,m,k,index+1,cost+1,j);
                } 
            }
            else {
                ans += solve(n,m,k,index+1,cost,max);
            }
            ans %= MOD;
        }
        return  t[index][cost][max] =(int)ans ;
    }
}