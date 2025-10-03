class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int n = numBottles;
        int i = numExchange;
        int sum =n;
        if(i > n) return n;
        while(n >= i){
            int rem = n % i;
            n = n / i ;
            sum += n;
            n = n+ rem;
        }
        // if(n > 1) sum++;
        return sum;
    }
}