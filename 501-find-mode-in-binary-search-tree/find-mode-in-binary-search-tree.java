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
    private Map<Integer,Integer> map = new HashMap<>();
    public int[] findMode(TreeNode root) {
        helper(root);
        int max = 0;
        for(int i : map.values()){
            max = Math.max(max,i);

        }
        List<Integer> res = new ArrayList<>();
        for(Map.Entry<Integer,Integer> i: map.entrySet()){
            if(i.getValue()==max){
               res.add(i.getKey());
            }
        }
        int[] ans = new int[res.size()];
        for(int i = 0 ;i< res.size();i++){
            ans[i] = res.get(i);
        }
        return ans;
    }
    private void helper(TreeNode root){
        if(root == null) return;
        helper(root.left);
        map.put(root.val,map.getOrDefault(root.val,0)+1);
        helper(root.right);
    }
}