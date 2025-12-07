/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    private Map<TreeNode,TreeNode> parent = new HashMap<>();
    private Set<TreeNode> visited= new HashSet<>();
    private List<Integer> res = new ArrayList<>();

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        
        parent(root);
        helper(target,k);
        return res;
    }
    private void parent(TreeNode root){
        if(root == null) return;
        if(root.left != null) parent.put(root.left,root);
        if(root.right != null) parent.put(root.right,root);
        parent(root.left);
        parent(root.right);

    }
    private void helper(TreeNode root,int k){
        if(root == null) return;
        if(visited.contains(root)) return;
        if(k==0) {
            res.add(root.val);
            return;
        }
        visited.add(root);
        if(root.left != null && !visited.contains(root.left)){
            helper(root.left,k-1);
        }

        if(root.right != null && !visited.contains(root.right)){
            helper(root.right,k-1);
        }
        
        TreeNode node = parent.get(root);
        if(node != null && !visited.contains(node)){
            helper(node,k-1);
            
        }
        
    }
}