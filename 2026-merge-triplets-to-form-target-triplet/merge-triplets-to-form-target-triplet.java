class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        int n = triplets.length;
        boolean compare[] = new boolean[n];
        for(int i =0;i<n;i++){
            int a = triplets[i][0];
            int b = triplets[i][1];
            int c = triplets[i][2];
            if(a > target[0] || b > target[1] || c > target[2]){
                compare[i] = true;
            }
        }
        int a=0;
        int b = 0;
        int c = 0;
        for(int i = 0;i<n;i++){
            if(compare[i] == true){
                continue;
            }
            a = Math.max(a,triplets[i][0]);
            b = Math.max(b,triplets[i][1]);
            c = Math.max(c,triplets[i][2]);
        }
        return a == target[0] && b == target[1] && c == target[2];
    }
}