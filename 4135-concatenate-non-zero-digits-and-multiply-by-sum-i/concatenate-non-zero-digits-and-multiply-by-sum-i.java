class Solution {
    public long sumAndMultiply(int n) {
        if(n ==0) return 0;
        long sum = 0;
        String concat = "";
        while(n!=0){
            int temp = n % 10;
            sum += temp;
            if(temp !=0){
                concat += temp;
            }
            n = n / 10;
        }
        long m = Integer.parseInt(new StringBuilder(concat).reverse().toString());
        m = m * sum ;
        return m;
    }
}