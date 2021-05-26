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
    public int longestUnivaluePath(TreeNode root) {
        if(root == null)
            return 0;
        
        
        int x = longestUnivaluePath(root.left);
        int y = longestUnivaluePath(root.right);
        
        
        return Math.max(solve(root.left, root)+solve(root.right, root),Math.max(x,y));
    }
    public int solve(TreeNode root, TreeNode par){
        if(root == null)
            return 0;
        
        if(par == null || (par != null && par.val != root.val))
            return 0;
        
        
        int x = solve(root.left, root);
        int y= solve(root.right, root);
        
      return 1+Math.max(x,y);        
    }
}