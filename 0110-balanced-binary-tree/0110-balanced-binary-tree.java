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
    boolean bal = true;
    public boolean isBalanced(TreeNode root) {
      if(root == null)
          return true;
        s(root);
        return  bal;
    }
    
    
    public int s(TreeNode root){
        if(root == null)
            return 0;
        
        
        int left = s(root.left);
        int right = s(root.right);
        
        bal = bal && Math.abs(left-right) <= 1;
        return 1+Math.max(left, right);
    }
}