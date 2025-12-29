/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private int count = 0;

    public int pathSum(TreeNode root, int targetSum) {
        Deque<Integer> dq = new ArrayDeque<>();
        helper(root, targetSum, dq);
        return count;
    }

    private void helper(TreeNode root, int target, Deque<Integer> dq) {
        if (root == null)
            return;

        dq.addFirst(root.val);

        long temp = 0;
        for (int val : dq) {
            temp += val;
            if (temp == (long)target)
                count++;
        }
        helper(root.left, target, dq);
        helper(root.right, target, dq);
        dq.removeFirst();
    }
}