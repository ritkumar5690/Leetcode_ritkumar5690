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
    // private int binary(int[] arr,int target,boolean flag){
    //     int star =0,end = arr.length-1;
    //     int res = -1;
    //     while(star <= end){
    //         int mid = star + (end-star)/2;
    //         if(flag && arr[mid] <= target){
    //             res = arr[mid];
    //             star = mid+1;
    //         } 
    //         else if(flag && arr[mid] > target){
    //             end = mid-1;
    //         }
    //         if(!flag && arr[mid] < target){
               
    //             star = mid+1;
    //         } 
    //         else if(!flag && arr[mid] >= target){
    //             res = arr[mid];
    //             end = mid-1;
    //         }

    //     }
    //     return res;
    // }
    private void helper(TreeNode root){
        if(root == null) return;
        helper(root.left);
        set.add(root.val);
        helper(root.right);
    }
}