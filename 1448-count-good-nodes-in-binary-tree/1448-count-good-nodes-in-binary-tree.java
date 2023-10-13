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
    public int goodNodes(TreeNode root) {
        return s(root, Integer.MIN_VALUE);
    }
    
    public int s(TreeNode root, int mx){
        if(root == null)
            return 0;
        
        if(mx <= root.val)
            return 1+s(root.left, root.val)+ s(root.right, root.val);
        
        return  s(root.left, mx)+ s(root.right, mx);
    }
}