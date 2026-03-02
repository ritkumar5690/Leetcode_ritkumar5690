class Solution {
    public int minSwaps(int[][] grid) {
        int n = grid.length;
        int[] arr = new int[n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = calZero(grid, i, n);
        }
        for (int i = 0; i < n ; i++) {
            int j = i;
            while (j < n && arr[j] < n - i - 1) {
                j++;
            }
            if (j == n)
                return -1;
            while (j > i) {
                int temp = arr[j];
                arr[j] = arr[j - 1];
                arr[j - 1] = temp;
                j--;
                count++;
            }
        }
        return count;
    }

    private int calZero(int[][] grid, int j, int n) {
        int count = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (grid[j][i] != 0) {
                break;
            }
            count++;
        }
        return count;
    }
}

// //int j =i;
//             if(grid[i][n-1] == 1){
//                 int j =i;
//                 while(j+1>n){
//                 int[] temp = grid[j];
//                 grid[j] = grid[j+1];
//                 grid[j+1] = temp;
//                 j++;
//                 count++;
//             }
//             }
//             while(cacZero() != n-i-1){
//                 if(j == n-1) j=i;
//                 int[] temp = grid[j];
//                 grid[j] = grid[j+1];
//                 grid[j+1] = temp;
//                 j++;
//                 count++;
//             }
//         }

//         for(int i=0;i<n;i++){

//         }
//         //