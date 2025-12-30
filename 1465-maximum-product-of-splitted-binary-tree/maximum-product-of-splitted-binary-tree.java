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
    private long max = 0;
    private static final int M = 1000000007;
    public int maxProduct(TreeNode root) {
       long sum = total(root);
       helper(root,sum);
       return (int)(max % M);
    }
    private long helper(TreeNode root,long sum){
        if(root == null) return 0;

        long lh = helper(root.left,sum);
        long rh =helper(root.right,sum);

        long restSum = root.val + lh + rh;
        long pro = restSum * (sum - restSum) ;
        max = Math.max(max,pro);
        return restSum;
    }
    private long total(TreeNode root){
        if(root == null) return 0;
        long lh = total(root.left);
        long rh = total(root.right);
        return root.val + lh+ rh;
    }
}