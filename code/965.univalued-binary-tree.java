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
    public boolean isUnivalTree(TreeNode root) {
        int val = root.val;
        return solve(root, val);
    }
    
    public boolean solve(TreeNode root, int val){
        
        if(root == null)
            return true;
        
        if(root.val != val)
            return false;
        
        return solve(root.left, val) && solve(root.right, val);
        
    }
}