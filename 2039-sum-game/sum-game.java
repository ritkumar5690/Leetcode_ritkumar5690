class Solution {
    public boolean sumGame(String num) {
        int n = num.length();
        int mid = n / 2;
        int sum1 = 0, sum2 = 0;
        int q1 = 0, q2 = 0;
        for (int i = 0; i < n; i++) {
            char ch = num.charAt(i);
            if (i < mid) {
                if (ch == '?') {
                    q1++;
                } else {
                    sum1 += ch - '0';
                }

            } else {
                if (ch == '?') {
                    q2++;
                } else {
                    sum2 += ch - '0';
                }
            }

        }
        // if ((q1 + q2) % 2 == 1) {
        //     return true;
        // }
        return 2 * (sum1 - sum2) != 9*(q2-q1);

    }
}