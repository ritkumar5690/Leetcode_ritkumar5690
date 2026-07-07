class Solution {
    public long sumAndMultiply(int n) {
        if(n ==0) return 0;
        long sum = 0;
        long ans = 0;
        long num = 0;
        while(n!=0){
            int temp = n % 10;
            sum += temp;
            if(temp !=0){
                num = num * 10 + temp;
            }
            n = n / 10;
        }
        while(num!=0){
            ans = ans*10 + num % 10;
            num = num / 10;
        }
        return ans * sum;
    }
}