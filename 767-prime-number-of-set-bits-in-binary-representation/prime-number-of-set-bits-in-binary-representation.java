class Solution {
    public int countPrimeSetBits(int left, int right) {
        int count =0;
        for(int i = left ;i<= right;i++){
            if(isPrimeBit(i)) count++;
        }
        return count;
    }
    private boolean isPrimeBit(int i){
        int count = 0;
        while(i !=0){
            i &= (i-1);
            count++;
        }
        if(count<2) return false;
        for(int j =2;j<=Math.sqrt(count);j++){
            if(count%j==0) return false;
        }
        return true;
    }
}