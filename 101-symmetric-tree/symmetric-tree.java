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
    public boolean isSymmetric(TreeNode root) {
        if(root.left == null && root.right == null) return true;
        if(root.left ==null || root.right ==null) return false;
        if(root.left.val != root.right.val) return false;
       return check(root.left,root.right);
    }
    private boolean check(TreeNode root,TreeNode root2){
        if(root == null && root2 == null) return true;
        if(root ==null || root2 ==null ) return false;
        if(root.val != root2.val) return false;
        

        return check(root.left,root2.right) && check(root.right,root2.left);
    }

}