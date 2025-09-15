class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        int n = text.length();
        int count = 0,j=0,spa = 0;
        int m = brokenLetters.length();
        while(j < n){
            int s = j;
            while(j < n && text.charAt(j) != ' '){
                j++;
            }
            spa++;
            j++;
        }
        j =0;
        if(m == 0) return spa;
        while(j < n){
            int s = j;
            while(j < n && text.charAt(j) != ' '){
                j++;
            }
            String str = text.substring(s,j);
            for(int i =0;i<m;i++){
                char ch = brokenLetters.charAt(i);
                if(str.contains(String.valueOf(ch))){
                   count++;
                   break;
                }
            }
            j++;
        }
        return spa-count;
    }
}