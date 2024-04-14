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
    public int sumOfLeftLeaves(TreeNode root) {
        return s(root, false);
    }
    
    public int s(TreeNode root, boolean l){
        if(root == null)
            return 0;
        
        return (l && root.left == null && root.right == null ? root.val : 0)+s(root.left, true)+s(root.right, false);
    }
}