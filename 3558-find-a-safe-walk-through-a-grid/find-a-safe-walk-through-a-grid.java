class Solution {
    private int direction[][] = {{ -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        int n = grid.size();
        int m = grid.get(0).size();
        int dist[][] = new int[n][m];
        for (int[] row : dist)
            Arrays.fill(row, Integer.MAX_VALUE);
        Deque<int[]> deq = new ArrayDeque<>();

         dist[0][0] = grid.get(0).get(0);
        deq.addFirst(new int[]{0,0});
        
        while (!deq.isEmpty()) {
            int[] curr = deq.pollFirst();
            int x = curr[0];
            int y = curr[1];
            if(x == n-1 && y == m-1){
                return dist[x][y] < health;
            }
            for(int dir[] : direction){
                int nx = x + dir[0];
                int ny = y + dir[1];
                if(nx < 0 || nx >= n || ny < 0 || ny >= m) {
                    continue;
                }
                int w = grid.get(nx).get(ny);
                if(dist[x][y] + w < dist[nx][ny]){
                    dist[nx][ny] = dist[x][y] + w;
                if (w == 0)
                        deq.offerFirst(new int[]{nx, ny});
                else
                        deq.offerLast(new int[]{nx, ny});
                }        
            }
        }

        return dist[n-1][m-1] < health;
    }

}