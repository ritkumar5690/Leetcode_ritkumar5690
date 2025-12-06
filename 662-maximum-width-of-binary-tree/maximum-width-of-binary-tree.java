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
    private long max=0;
    private List<Long> res = new ArrayList<>();
    public int widthOfBinaryTree(TreeNode root) {
        helper(root,0,0L);
        return (int)max;
    }
    private void helper(TreeNode root,int level, long index){
        if(root == null) return;

        if(res.size() == level){
            res.add(index);
        }
        long width = index - res.get(level) +1;
        max = Math.max(max,width);
        helper(root.left,level+1,2*index + 1);
        helper(root.right,level+1,2*index + 2);
        
    }
}