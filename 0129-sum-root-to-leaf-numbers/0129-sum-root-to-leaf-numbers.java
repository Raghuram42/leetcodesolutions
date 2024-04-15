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
    public int sumNumbers(TreeNode root) {
        if(root == null)
            return 0;
        
        
        return solve(root, 0);
    }
    public int solve(TreeNode root, int ans){
        if(root == null)
            return 0;
        if(root.left == null && root.right == null)
            return ans*10+root.val;
        return solve(root.left, ans*10+root.val)+solve(root.right, ans*10+root.val);
    }
}