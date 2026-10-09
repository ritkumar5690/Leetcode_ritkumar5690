class Solution {
    public int minInsertions(String s) {
        Deque<Character> st = new ArrayDeque<>();
        int close = 0;
        int res = 0;
        for(char i : s.toCharArray()){
            if(i == '('){
                
                if(close == 1 && st.isEmpty()){
                    res += 2;
                    close = 0;
                }
                else if(close == 1 && !st.isEmpty()){
                    res += 1;
                    st.pop();
                    close = 0;
                }
                st.push(i);
            }
            else{
                close++;
                
                if(close == 2 && st.isEmpty()){
                    res += 1;
                    close = 0;     
                }
                else if(close==2 && st.peek() == '('){
                    st.pop();
                    close = 0;  
                }
            }
        }
        int count = 0;
        if(close == 1 && !st.isEmpty()){
            res += 1;
            st.pop();
        }
        else if(close == 1 && st.isEmpty()){
            res += 2;
        }
        while(!st.isEmpty()){
            count += 2 ;
            st.pop();
        }
        // if( > 0){
        //     res = res - tclose;
        // }
        return res +count; 
    }
}