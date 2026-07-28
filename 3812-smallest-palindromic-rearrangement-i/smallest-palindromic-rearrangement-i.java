class Solution {
    public String smallestPalindrome(String s) {
        if(s.length() ==1) return s;
        int mid = s.length()/2;
        String str = "";
        if(s.length()%2 != 0){
            str = String.valueOf(s.charAt(mid));
        }
        int count[] = new int[26]; 
        for(int i = 0;i<mid;i++){
            count[s.charAt(i)-'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i<26;i++){
            sb.append(String.valueOf((char) (i + 'a')).repeat(count[i]));
        }


        // char[] ch = s.substring(0,mid).toCharArray();
        // Arrays.sort(ch);
        // String sorted = new String(ch); 
        String rev = new StringBuilder(sb).reverse().toString();
        return sb.toString() + str + rev;
    }
}