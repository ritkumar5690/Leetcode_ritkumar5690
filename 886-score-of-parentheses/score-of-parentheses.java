class Solution {
    public int scoreOfParentheses(String s) {
        Deque<Character> st = new ArrayDeque<>();
        st.push(s.charAt(0));
        for(char ch :s.toCharArray()){
            if(ch == '('){
                st.push(ch);
            }
            if(ch == ')'){
                if(st.peek()=='('){
                    st.pop();
                    if(!st.isEmpty() && st.peek() != '('){
                        int num = st.pop()-'0';
                        num = num+1;
                        char c = (char) (num + '0');
                        st.push(c);
                    }
                    else{
                        int num = 1;
                        char c = (char) (num + '0');
                        st.push(c);
                    }
                }
                else{
                    int num =2* (st.pop()-'0');
                    st.pop();
                    int temp =0;
                    if(!st.isEmpty() && st.peek() != '('){
                        temp = st.pop()-'0';

                    }
                    char c = (char) ((num +temp) + '0');
                    st.push(c);

                }
            }
        }
        return st.pop()-'0';
    }
}