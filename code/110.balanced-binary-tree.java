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
            boolean res;
    public boolean isBalanced(TreeNode root) {
res = true;
      if(root == null || (root.left == null && root.right == null)) 
          return res;
        
      // int lft = isBalance(root.left);
      // int right = isBalance(root.right);
        isBalance(root);
        return res;
        
    }
    public int isBalance(TreeNode root) {
        if(root == null) 
          return 0;
 
        int lft = 1+isBalance(root.left);
        int right = 1+isBalance(root.right);
        if(Math.abs(lft-right)>1)
            res = false;
        return Math.max(lft, right);
    }
}