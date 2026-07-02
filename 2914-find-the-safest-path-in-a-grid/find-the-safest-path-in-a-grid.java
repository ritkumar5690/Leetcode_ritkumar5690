class Solution {
    private int direction[][] = { { 1, 0 }, { -1, 0 }, { 0, -1 }, { 0, 1 } };
    public int maximumSafenessFactor(List<List<Integer>> grid) {
        int n = grid.size();
        if (grid.get(n - 1).get(n - 1) == 1 || grid.get(0).get(0) == 1)
            return 0;
        Queue<Pair<Integer, Integer>> que = new LinkedList<>();
        int res = 0;
        int mat[][] = new int[n][n];
        boolean visited[][] = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid.get(i).get(j) == 1) {
                    que.add(new Pair<>(i, j));
                    visited[i][j] = true;
                }
            }
        }
        int level = 0;
        while (!que.isEmpty()) {
            int s = que.size();
            while (s-- > 0) {
                Pair<Integer, Integer> cur = que.poll();
                int curi = cur.getKey();
                int curj = cur.getValue();
                mat[curi][curj] = level;
                for (int[] dir : direction) {
                    int newi = curi + dir[0];
                    int newj = curj + dir[1];
                    if (newi < 0 || newi >= n || newj < 0 || newj >= n || visited[newi][newj]) {
                        continue;
                    }
                    que.add(new Pair<>(newi, newj));
                    visited[newi][newj] = true;
                }
            }
            level++;
        }

        return binary(0, 400, mat);
    }

    private int binary(int s, int e, int mat[][]) {
        int res = 0;
        while (s <= e) {
            int mid = (e - s) / 2 + s;
            if (check(mat, mid)) {
                res = mid;
                s = mid + 1;
            } else {
                e = mid - 1;
            }
        }
        return res;
    }

    private boolean check(int mat[][], int target) {
        int n = mat.length;
        if (mat[0][0] < target)
            return false;
        Queue<Pair<Integer, Integer>> que = new LinkedList<>();
        boolean visited[][] = new boolean[n][n];
        que.add(new Pair<>(0, 0));
        visited[0][0] = true;
        while (!que.isEmpty()) {
            Pair<Integer, Integer> cur = que.poll();

            int i = cur.getKey();
            int j = cur.getValue();
            for (int[] dir : direction) {

                int ni = i + dir[0];
                int nj = j + dir[1];

                if (ni < 0 || nj < 0 || ni >= n || nj >= n)
                    continue;

                if (visited[ni][nj])
                    continue;

                if (mat[ni][nj] < target)
                    continue;

                visited[ni][nj] = true;
                que.add(new Pair<>(ni, nj));
            }
            if (i == n - 1 && j == n - 1) {
                return true;
            }
        }

        return false;

    }
}