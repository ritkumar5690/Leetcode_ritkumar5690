class Solution {
    public int kthGrammar(int n, int k) {
       if (n == 1 && k == 1) return 0;
       int res = kthGrammar(n-1,(k+1)/2);
       if(k%2 == 1){
        return res;
       }
       else{
        return  1-res;
       }
    } 
    
}