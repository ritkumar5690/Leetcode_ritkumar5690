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
    private int max = 0;

    public int longestUnivaluePath(TreeNode root) {
        helper(root);
        return max;
    }
    private int helper(TreeNode root){
        if(root == null){
            return 0;
        }
        int lh = helper(root.left);
        int rh = helper(root.right);
        int leftCount =0;
        int rightCount =0;

        if(root.left!=null && root.val == root.left.val){
            leftCount = lh +1;
        }
        if(root.right!=null && root.val == root.right.val){
            rightCount = rh +1;
        }
        
        max = Math.max(max,leftCount+rightCount);
        
        return Math.max(leftCount,rightCount);

    }
}