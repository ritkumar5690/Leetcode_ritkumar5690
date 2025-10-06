

class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        boolean[][] visited = new boolean[n][n];
        
        // Min-heap based on the height at the cell
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        pq.offer(new int[]{0, 0, grid[0][0]});
        visited[0][0] = true;
        
        int res = 0;
        
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int i = cur[0], j = cur[1], t = cur[2];
            res = Math.max(res, t);
            
            if (i == n - 1 && j == n - 1) return res;
            
            for (int[] dir : dirs) {
                int x = i + dir[0];
                int y = j + dir[1];
                if (x >= 0 && y >= 0 && x < n && y < n && !visited[x][y]) {
                    visited[x][y] = true;
                    pq.offer(new int[]{x, y, grid[x][y]});
                }
            }
        }
        
        return res;
    }
}
