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
    private TreeSet<Integer> set = new TreeSet<>();
    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        helper(root);
        List<List<Integer>> list= new ArrayList<>();
        for (int q : queries) {
            Integer f = set.floor(q);
            Integer c = set.ceiling(q);

            list.add(Arrays.asList(
                f == null ? -1 : f,
                c == null ? -1 : c
            ));
        }
        return list;
    }
    
    private void helper(TreeNode root){
        if(root == null) return;
        helper(root.left);
        set.add(root.val);
        helper(root.right);
    }
}