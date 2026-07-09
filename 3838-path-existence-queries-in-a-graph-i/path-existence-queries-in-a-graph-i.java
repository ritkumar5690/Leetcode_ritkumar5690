class Solution {
    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        boolean res[] = new boolean[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int a = 0;
            int b = 0;
            if (queries[i][0] < queries[i][1]) {
                a = queries[i][0];
                b = queries[i][1];
            } else {
                b = queries[i][0];
                a = queries[i][1];
            }
            if (Math.abs(a - b) == 0) {
                res[i] = true;
            } else if (Math.abs(a - b) == 1 && Math.abs(nums[a] - nums[b]) <= maxDiff) {
                res[i] = true;
            } else if (Math.abs(a - b) > 1) {
                if (Math.abs(nums[a] - nums[b]) <= maxDiff) {
                    res[i] = true;
                } else {
                    int pNode1 = a;
                    int pNode2 = a + 1;
                    while (pNode2 <= b && Math.abs(nums[pNode1] - nums[pNode2]) <= maxDiff) {
                        
                        pNode1 = pNode2;
                        pNode2 = pNode2 + 1;
                    }
                    if(pNode2 == b && Math.abs(nums[pNode1] - nums[pNode2]) > maxDiff){
                        res[i] = false;
                    }
                    else if (pNode2 >= b) {
                        res[i] = true;
                    }
                }
            } else {
                res[i] = false;
            }
        }
        return res;
    }

}