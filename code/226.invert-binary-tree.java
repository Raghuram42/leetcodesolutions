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
    public TreeNode invertTree(TreeNode root) {
        helperInvert(root);
        return root;
    }
    public void helperInvert(TreeNode root){
        if(root == null || root.left == null && root.right == null)
            return;
        
        TreeNode lft = root.left;
        TreeNode rht = root.right;
        
        root.left = rht;
        root.right = lft;
        
        if(root.left != null)
            helperInvert(root.left);
            
        
        if(root.right != null)
            helperInvert(root.right);
            
    }
}