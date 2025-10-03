class Solution {
    public int maxBottlesDrunk(int numBottles, int numExchange) {
        int n = numBottles;
        int i = numExchange;
        int sum =n;
        if(i > n) return n;
        int count =0;
        while(n >= i){
            int rem = n % i;
            n = n - i ;
            count += 1;
            i++;
            if(n < i){
                n = n+ count;
                sum += count;
                count =0;
            }
            
        }
        return sum;
    }
}