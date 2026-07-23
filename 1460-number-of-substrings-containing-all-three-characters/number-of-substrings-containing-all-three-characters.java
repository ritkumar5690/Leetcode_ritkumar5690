class Solution {
    public int numberOfSubstrings(String s) {
        int count[] = new int[3];
        int res = 0,j =0;
        int n = s.length();
        for(int i =0;i<n;i++){
            count[s.charAt(i)-'a']++;
            while(count[0]>0 && count[1] > 0 && count[2] > 0){
                res += n-i;
                count[s.charAt(j)-'a']--;
                j++;
            }
        }
        return res;
    }
}