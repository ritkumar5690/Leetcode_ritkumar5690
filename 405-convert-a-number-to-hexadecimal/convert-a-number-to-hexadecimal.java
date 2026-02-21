class Solution {
    public String toHex(int num) {
        if(num == 0) return "0";
        String str = "";
        char[] hexChars = { 'a', 'b', 'c', 'd', 'e', 'f' };
        while (num != 0) {
            int n = num & 15;
            if (n < 10) {
                str = n + str;
            } else {
                str = hexChars[n - 10] + str;
            }
           num >>>= 4;
        }
        return str;
    }
}