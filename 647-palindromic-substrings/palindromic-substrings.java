class Solution {
    public int countSubstrings(String s) {
        int n = s.length();

        if(n<1 && s== null){
            return 0;
        }
        int count = 0;
        for(int i =0;i<n;i++){
            count += palindrome(s,i,i);
            count += palindrome(s,i,i+1);

        }
        return count;
    }
    private int palindrome(String s, int i,int j){
        int res = 0;
        while(j < s.length() && i>= 0 && s.charAt(i) == s.charAt(j)){
            res++;
            j++;
            i--;
        }
        return res;
    }
}