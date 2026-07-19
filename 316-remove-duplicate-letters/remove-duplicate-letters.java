class Solution {
    public String removeDuplicateLetters(String s) {
        int lastIndex[] = new int[26];
        boolean visited[] = new boolean[26];
        Deque<Character> stack = new ArrayDeque<>();
       for (int i = 0; i < s.length(); i++) {
    lastIndex[s.charAt(i) - 'a'] = i;
}
        char[] chars = s.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            char ch = chars[i];
            if (visited[ch - 'a']) {
                continue;
            }
            while (!stack.isEmpty() && stack.peek() > ch && (lastIndex[stack.peek() - 'a'] > i)) {
                char rev = stack.pop();
                visited[rev - 'a'] = false;

            }

            stack.push(ch);
            visited[ch - 'a'] = true;
        }
        StringBuilder sb = new StringBuilder();
        for (char ch : stack) {
            sb.append(ch);
        }
        return sb.reverse().toString();
    }
}