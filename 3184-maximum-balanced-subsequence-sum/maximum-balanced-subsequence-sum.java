class Solution {
    public long maxBalancedSubsequenceSum(int[] nums) {

        int n = nums.length;

        long[] key = new long[n];

        for (int i = 0; i < n; i++) {
            key[i] = (long) nums[i] - i;
        }

        long[] sorted = key.clone();

        Arrays.sort(sorted);
        int size = 0;

        for (int i = 0; i < n; i++) {
            if (i == 0 || sorted[i] != sorted[i - 1]) {
                sorted[size++] = sorted[i];
            }
        }

        FenwickTree tree = new FenwickTree(size);

        long ans = Long.MIN_VALUE;

        for (int i = 0; i < n; i++) {

            int pos = Arrays.binarySearch(sorted, 0, size, key[i]) + 1;

            long best = tree.query(pos);

            long current = nums[i];

            if (best != Long.MIN_VALUE) {
                current = Math.max(current, nums[i] + best);
            }
            tree.update(pos, current);

            ans = Math.max(ans, current);
        }

        return ans;
    }

    static class FenwickTree {

        long[] tree;

        FenwickTree(int n) {
            tree = new long[n + 1];
            Arrays.fill(tree, Long.MIN_VALUE);
        }

        void update(int i, long value) {

            while (i < tree.length) {
                tree[i] = Math.max(tree[i], value);
                i += i & -i;
            }
        }

        long query(int i) {
            long ans = Long.MIN_VALUE;

            while (i > 0) {
                ans = Math.max(ans, tree[i]);
                i -= i & -i;
            }

            return ans;
        }
    }
}