class Solution {
    public boolean doesAliceWin(String s) {
        int count = 0;
        for(int i =0;i<s.length();i++){
            char ch = s.charAt(i);
            if(isVowel(ch)){
                count++;
            }
        }
        if(count == 0){
            return false;
        }
        return true;
    }
    private boolean isVowel(char s){
        return "aeiou".indexOf(s) != -1;
    }
}