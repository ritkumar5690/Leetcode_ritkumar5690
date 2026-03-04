class Solution {
    public int numSpecial(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int count = 0;
        for(int i =0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(mat[i][j] == 1 && special(mat, i,j)){
                    count++;
                    break;
                }
            }
        }
        return count;
    }
    private boolean special(int[][] mat,int i,int j){
        int n = mat.length;
        int m = mat[0].length;
        int k =0;
        int l =0;
        while(k < n){
            if(k != i && mat[k][j]==1){
                return false;
            }
            k++;
        }

        while(l < m){
            if(l!=j && mat[i][l]==1){
                return false;
            }
            l++;
        }
        return true;
    }
}