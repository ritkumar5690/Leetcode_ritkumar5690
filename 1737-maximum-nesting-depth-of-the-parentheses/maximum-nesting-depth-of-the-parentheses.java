class Solution {
    public int maxDepth(String s) {
        int res = 0;
        int ans = 0;
        for(int i =0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch == '('){
                res++;
            }
            if(ch == ')'){
                res--;
            }
            ans = Math.max(ans,res);
        }
        return ans;
    }
}