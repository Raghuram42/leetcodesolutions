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
    TreeNode sub;
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
       if(root == null && subRoot == null)
            return true;
        
        if(root == null || subRoot == null)
            return false;
        
        // if(root.val == subRoot.val)
            if(s(root, subRoot))
                return true;
        
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }
    
    public boolean s(TreeNode root, TreeNode subRoot){
        if(root == null && subRoot == null)
            return true;
        
        if(root == null || subRoot == null)
            return false;
        
        boolean ans = false;
        if(root.val == subRoot.val)
            return s(root.left, subRoot.left) && s(root.right, subRoot.right);
        
        return false;
    }
}