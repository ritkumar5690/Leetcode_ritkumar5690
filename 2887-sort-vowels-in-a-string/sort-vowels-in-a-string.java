class Solution {
    public String sortVowels(String s) {
        int n = s.length();
        if (n == 1)
            return s; 
        List<Character> vol = new ArrayList<>();    
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (isVowel(ch)){
                vol.add(ch);
            }
        }
        Collections.sort(vol);
        int idx =0;
        StringBuilder sb = new StringBuilder();
        for(char c : s.toCharArray()) {
            if(isVowel(c)){
                sb.append(vol.get(idx++));
            }
            else{
                sb.append(c);
            }
        } 
        return sb.toString();      
    }
    private boolean isVowel(char c){
        return "aeiouAEIOU".indexOf(c) != -1;
    }
}