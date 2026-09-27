class Solution {
    public String reverseParentheses(String s) {
        Deque<Character> st = new ArrayDeque<>();
        int n = s.length();
        int i =0;
        while(i<n){
            char ch = s.charAt(i);
            if(ch == ')'){
                Queue<Character> st2 = new ArrayDeque<>();
                char ch1 = st.pop();
                while(ch1 != '('){
                    st2.offer(ch1);
                    ch1 = st.pop();
                }
                while(!st2.isEmpty()){
                    st.push(st2.poll());
                }
            }
            st.push(ch);
            i++;
        }
        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()){
            sb.append(st.pop());
        }
        return sb.reverse().toString().replace(")", "");

    }
}