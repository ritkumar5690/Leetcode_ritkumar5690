class Solution {
    public double myPow(double x, int n) {
        if (x>1.0 && n<-2147483647) return 0;
        double res= 1;
        for(long i = Math.abs(n);i>=1;){
            if(i%2==0){
                i = i/2;
                x = x * x;
            }
            else{
                res = res * x;
                i = i-1;
            }
        }
        if(n < 0){
            return 1.0/res;
        }

        return res;
    }
}