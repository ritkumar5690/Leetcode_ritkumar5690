class Solution {
    public boolean isValid(String s) {
        Stack<Character> stk = new Stack<>();
        for(char ch:s.toCharArray()){
            if (ch == '(' || ch == '[' || ch == '{') {
                stk.push(ch);
            }
            else if (ch == ')' && !stk.isEmpty() && stk.peek() == '(') {
                stk.pop();
            } else if (ch == '}' && !stk.isEmpty() && stk.peek() == '{') {
                stk.pop();
            } else if (ch == ']' && !stk.isEmpty() && stk.peek() == '[') {
                stk.pop();
            } else {
                return false;
            }
        }
        return stk.isEmpty();
    }
}