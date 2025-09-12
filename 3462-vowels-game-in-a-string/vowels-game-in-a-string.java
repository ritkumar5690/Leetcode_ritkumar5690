class Solution {
    public boolean doesAliceWin(String s) {
        int n = s.length();
        int count = 0;
        for(int i =0;i<n;i++){
            char ch = s.charAt(i);
            if(isVowel(ch)){
                count++;
            }
        }
        if(count == 0){
            return false;
        }
        if(count % 2 != 0){
            return true;
        }
        return true;
    }
    private boolean isVowel(char s){
        return "aeiou".indexOf(s) != -1;
    }
}