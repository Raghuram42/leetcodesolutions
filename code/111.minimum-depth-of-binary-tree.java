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
    int res;
    public int minDepth(TreeNode root) {
        if(root == null)
            return 0;
     res = Integer.MAX_VALUE;
     solve(root, 0);   
        return res == Integer.MAX_VALUE ? 0 : res; 
    }
    public void solve(TreeNode root, int dep){
        if(root == null)
            return;
        if(root.left == null && root.right == null){
            res = Math.min(1+dep, res);
            return;
        }
        
        solve(root.left, dep+1);
        solve(root.right, dep+1);
    }
}