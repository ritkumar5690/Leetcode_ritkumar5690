class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        int n = intervals.length;
        int count = n;
        for (int i = 0; i < n; i++) {
            int a = intervals[i][0];
            int b = intervals[i][1];
            boolean removed = false;
            for (int j = 0; j < n; j++) {
                if (i == j )
                    continue;
                int c = intervals[j][0];
                int d = intervals[j][1];
                if (c <= a && b <= d) {
                    removed = true;
                    count--;
                    break;
                } 
            }
        }
        return count;
    }
}