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
    private int max = Integer.MIN_VALUE;

    public int diameterOfBinaryTree(TreeNode root) {
        if(root.left == null && root.right == null) return 0;
        helper(root);
        return max;
    }
    private int helper(TreeNode root){
        if(root == null) return 0;
        
        int lh =  helper(root.left);
        int rh = helper(root.right);
        
        max = Math.max(max, lh+rh);

        return Math.max(lh,rh)+1;
    }
}