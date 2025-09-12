class Solution {
    public char findKthBit(int n, int k) {
         if(k == 1) return '0';
        String ans = findStr(n,"011",2);
       
        return ans.charAt(k-1);
    }
    private String findStr(int n , String str, int i){
        if(i == n){
            return str;
        }
       return findStr(n,str.substring(0, str.length()) + "1" +  new StringBuilder(invertBinary(str)).reverse().toString(),i+1);
        
    }
    private String invertBinary(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            sb.append(c == '0' ? '1' : '0');
        }
        return sb.toString();
    }
}