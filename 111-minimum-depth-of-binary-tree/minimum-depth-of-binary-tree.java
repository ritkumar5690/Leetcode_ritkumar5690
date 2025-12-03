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
    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        int lh = depth(root.left);
       
        int rh = depth(root.right);

        if(lh == 0 && rh ==0) return 1;
        else if(lh ==0 && rh !=0 || lh !=0 && rh == 0) return Math.max(rh,lh)+1;
        else return Math.min(rh,lh)+1;
    }
    public int depth(TreeNode root) {
        
        if(root == null) return 0;

        int lh = depth(root.left);
        
        int rh = depth(root.right);
        if(lh == 0 && rh ==0) return 1;
        else if(lh ==0 && rh !=0 || lh !=0 && rh == 0) return Math.max(rh,lh)+1;
        else return Math.min(rh,lh)+1;
    }
}