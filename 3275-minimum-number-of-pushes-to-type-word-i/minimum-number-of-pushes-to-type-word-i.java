class Solution {
    public int minimumPushes(String word) {
        if (word.length() <= 8)
            return word.length();
        int n = word.length();
        int ans = 0,i=1;

        while (i <= n) {
            if (i <= 8) {
                ans += 1;
            } else if (i > 8 && i <= 16) {
                ans += 2;
            } else if (i > 16 && i <= 24) {
                ans += 3;
            } else {
                ans += 4;
            }
            i++;
        }

        return ans;

    }
}