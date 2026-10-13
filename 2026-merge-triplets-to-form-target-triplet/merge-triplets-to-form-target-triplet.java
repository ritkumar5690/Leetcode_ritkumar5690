class Solution {
    public boolean mergeTriplets(int[][] tri, int[] target) {
        int n = tri.length;
        int a=0;
        int b = 0;
        int c = 0;
        for(int i = 0;i<n;i++){
            if(tri[i][0] > target[0] || tri[i][1]>target[1] || tri[i][2]>target[2]){
                continue;
            }
            a = Math.max(a,tri[i][0]);
            b = Math.max(b,tri[i][1]);
            c = Math.max(c,tri[i][2]);
        }
        return a == target[0] && b == target[1] && c == target[2];
    }
}