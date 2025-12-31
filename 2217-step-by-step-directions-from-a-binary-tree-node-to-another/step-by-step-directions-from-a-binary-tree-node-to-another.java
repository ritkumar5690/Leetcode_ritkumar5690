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
    public String getDirections(TreeNode root, int startValue, int destValue) {
        StringBuilder startpath = new StringBuilder();
        StringBuilder destpath = new StringBuilder();

        helper(root, startpath, startValue);
        helper(root, destpath, destValue);

        int i = 0;
        while (i < startpath.length() && i < destpath.length() && startpath.charAt(i) == destpath.charAt(i))  i++;

        StringBuilder result = new StringBuilder(); 

        for (int j = i; j < startpath.length(); j++) {
            result.append('U');
        }   
        result.append(destpath.substring(i));
        return result.toString();
    }

    private boolean helper(TreeNode root, StringBuilder path, int val) {
        if (root == null)
            return false;
        if (root.val == val)
            return true;

        path.append('L');
        if (helper(root.left, path, val))
            return true;
        path.deleteCharAt(path.length() - 1);

        path.append('R');
        if (helper(root.right, path, val))
            return true;
        path.deleteCharAt(path.length() - 1);

        return false;
    }
}