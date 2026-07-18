class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int count1[] = new int[26];
        int count2[] = new int[26];
        for(int i =0;i<s1.length();i++){
            count1[s1.charAt(i) - 'a']++;
        }
        int j = 0;
        for(int i = 0;i<s2.length();i++){
            count2[s2.charAt(i)-'a']++;
            if((i-j+1) == s1.length()){
                int k = 0;
                for(;k<26;k++){
                    if(count1[k] != count2[k]){
                        break;
                    }
                }
                if(k == 26){
                    return true;
                }
                else{
                    count2[s2.charAt(j)-'a']--;
                }
                j++;
            }

        }
        return false;
    }
}