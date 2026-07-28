class Solution {
    public String smallestPalindrome(String s) {
        if(s.length() ==1) return s;
        int mid = s.length()/2;
        String str = "";
        if(s.length()%2 != 0){
            str = String.valueOf(s.charAt(mid));
        }
        char[] ch = s.substring(0,mid).toCharArray();
        Arrays.sort(ch);
        String sorted = new String(ch); 
        String rev = new StringBuilder(sorted).reverse().toString();
        return sorted + str + rev;
    }
}