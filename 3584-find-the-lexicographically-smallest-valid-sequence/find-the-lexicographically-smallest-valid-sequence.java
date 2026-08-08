class Solution {
    public int[] validSequence(String word1, String word2) {

        int n = word1.length();
        int m = word2.length();
        int[] suffix = new int[n + 1];

        int j = m - 1;
        int count = 0;
        for (int i = n - 1; i >= 0; i--) {

            if (j >= 0 && word1.charAt(i) == word2.charAt(j)) {
                count++;
                j--;
            }

            suffix[i] = count;
        }

        int[] res = new int[m];

        int s = 0;
        int i = 0;
        j = 0;
        int k = 1; 

        while (i < n && j < m) {

            if (word1.charAt(i) == word2.charAt(j)) {

                res[s++] = i;
                j++;
            }

            else if (k > 0 &&
                     i + 1 <= n &&
                     suffix[i + 1] >= m - 1 - j) {

                res[s++] = i;
                j++;
                k--;
            }

            i++;
        }

        
        if (j == m) {
            return res;
        }

        return new int[]{};
    }
}