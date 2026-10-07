class Solution {
    private int n;
    private Set<String> set;
    private int maxLen = 0;
    public List<String> removeInvalidParentheses(String s) {
        n = s.length();
        set = new HashSet<>();
        
        
        solve(s,new StringBuilder(),0,0);
        return new ArrayList(set);
    }
    private void solve(String s, StringBuilder res,int i,int count){
        if(i == n){
            if(count == 0){
                if (res.length() > maxLen) {       // found a longer valid string
                    maxLen = res.length();
                    set.clear();
                }
                if (res.length() == maxLen) {
                    set.add(res.toString());
                }
            }
            
            return ;
        }
        if(count<0){
            return;
        }
        char ch = s.charAt(i);
        if(ch != '(' && ch != ')'){
            res.append(ch);
            solve(s,res,i+1,count);
            res.deleteCharAt(res.length() - 1);
            return ;
        }
        res.append(ch);
        solve(s,res,i+1,count + (ch == '(' ? 1 : -1));
        res.deleteCharAt(res.length() - 1);
        solve(s,res,i+1,count);
    

    }
}