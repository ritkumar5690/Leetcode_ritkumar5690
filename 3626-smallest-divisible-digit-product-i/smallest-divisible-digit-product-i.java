class Solution {
    public int smallestNumber(int n, int t) {
        for(int i = n;i<n+10;i++){
            if(productDigit(i) % t == 0){
                return i;
            }
        }
        return -1;
    }
    private int productDigit(int n){
        int pro = 1;
        while(n!=0){
            int digit = n %10;
            pro = pro * digit;
            n = n/10;
        }
        return pro;
    }

}