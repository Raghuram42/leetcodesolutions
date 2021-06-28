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
    public boolean isSymmetric(TreeNode root) {
        return isSym(root.left, root.right);
    }
    
    public boolean isSym(TreeNode left, TreeNode right){
        if(left == null && right == null)
            return true;
        if((left == null && right != null) || (right == null && left != null ))
            return false;
        
        if(left.val != right.val)
            return false;
        
        return isSym(left.left, right.right) && isSym(left.right, right.left);
    }
}
