class Solution {
    public boolean isPerfectSquare(int num) {
        long i =1;
        if(num ==1) return true;
        while(i* i <= num){
            if(i * i == num) return true;
            i++;
        }
        return false ;
    }
}