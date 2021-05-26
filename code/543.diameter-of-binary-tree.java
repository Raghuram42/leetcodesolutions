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
    int a;
    public int diameterOfBinaryTree(TreeNode root) {
        a = 1;
        dep(root);
        return a-1;
    }
    
    
    public int dep(TreeNode root){
        if(root == null)
            return 0;
        int l = dep(root.left);
        int r = dep(root.right);
        
        a = Math.max(a, l+r+1);
        return Math.max(l,r)+1;
        
    }
}