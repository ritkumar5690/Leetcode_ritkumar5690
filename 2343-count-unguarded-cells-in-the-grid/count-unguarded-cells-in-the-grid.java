class Solution {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int[][] mat = new int[m][n];

        for(int[] w : walls)
            mat[w[0]][w[1]] = -1;

        for(int[] g : guards)
            mat[g[0]][g[1]] = 2;

        for(int i = 0; i < m; i++) {
            boolean flag = false;

            for(int j = 0; j < n; j++) {
                if(mat[i][j] == -1)
                    flag = false;
                else if (mat[i][j] == 2)
                    flag = true;
                else if (flag)
                    mat[i][j] = 1;
            }
            flag = false;
            for (int j = n - 1; j >= 0; j--) {
                if (mat[i][j] == -1)
                    flag = false;
                else if (mat[i][j] == 2)
                    flag = true;
                else if (flag)
                    mat[i][j] = 1;
            }
        }

        for (int j = 0; j < n; j++) {
            boolean flag = false;
            for (int i = 0; i < m; i++) {
                if (mat[i][j] == -1)
                    flag = false;
                else if (mat[i][j] == 2)
                    flag = true;
                else if (flag)
                    mat[i][j] = 1;
            }

            flag = false;
            for (int i = m - 1; i >= 0; i--) {
                if (mat[i][j] == -1)
                    flag = false;
                else if (mat[i][j] == 2)
                    flag = true;
                else if (flag)
                    mat[i][j] = 1;
            }
        }

        int count = 0;
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (mat[i][j] == 0)
                    count++;

        return count;
    }
}
