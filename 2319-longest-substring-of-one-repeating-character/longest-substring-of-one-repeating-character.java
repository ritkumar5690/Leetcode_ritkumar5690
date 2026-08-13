class Solution {

    class Node {
        char leftChar;
        char rightChar;

        int prefix;
        int suffix;
        int longest;
        int length;

        Node() {}

        Node(char ch) {
            leftChar = ch;
            rightChar = ch;
            prefix = 1;
            suffix = 1;
            longest = 1;
            length = 1;
        }
    }

    Node[] tree;

    public int[] longestRepeating(
            String s,
            String queryCharacters,
            int[] queryIndices) {

        int n = s.length();
        int q = queryIndices.length;

        tree = new Node[4 * n];

        build(1, 0, n - 1, s);

        int[] ans = new int[q];

        for (int i = 0; i < q; i++) {

            int index = queryIndices[i];
            char ch = queryCharacters.charAt(i);

            update(1, 0, n - 1, index, ch);

            ans[i] = tree[1].longest;
        }

        return ans;
    }

    private void build(int node, int l, int r, String s) {

        if (l == r) {
            tree[node] = new Node(s.charAt(l));
            return;
        }

        int mid = l + (r - l) / 2;

        build(node * 2, l, mid, s);
        build(node * 2 + 1, mid + 1, r, s);

        tree[node] = merge(
            tree[node * 2],
            tree[node * 2 + 1]
        );
    }

    private void update(
            int node,
            int l,
            int r,
            int index,
            char ch) {

        if (l == r) {
            tree[node] = new Node(ch);
            return;
        }

        int mid = l + (r - l) / 2;

        if (index <= mid) {
            update(node * 2, l, mid, index, ch);
        } else {
            update(node * 2 + 1, mid + 1, r, index, ch);
        }

        tree[node] = merge(
            tree[node * 2],
            tree[node * 2 + 1]
        );
    }

    private Node merge(Node left, Node right) {

        Node res = new Node();

        res.length = left.length + right.length;

        res.leftChar = left.leftChar;
        res.rightChar = right.rightChar;

        res.prefix = left.prefix;
        res.suffix = right.suffix;

        res.longest = Math.max(
            left.longest,
            right.longest
        );

        if (left.rightChar == right.leftChar) {

            res.longest = Math.max(
                res.longest,
                left.suffix + right.prefix
            );

            if (left.prefix == left.length) {
                res.prefix =
                    left.length + right.prefix;
            }

            if (right.suffix == right.length) {
                res.suffix =
                    right.length + left.suffix;
            }
        }

        return res;
    }
}