class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        int n = intervals.length;
        int count = n;
        boolean removed[] = new boolean[n];
        for (int i = 0; i < n; i++) {
            int c = intervals[i][0];
            int d = intervals[i][1];
            for (int j = 0; j < n; j++) {
                if (i == j || removed[j])
                    continue;
                int a = intervals[j][0];
                int b = intervals[j][1];
                if (c <= a && b <= d) {
                    removed[j] = true;
                    count--;
                } 
            }
        }
        return count;
    }
}