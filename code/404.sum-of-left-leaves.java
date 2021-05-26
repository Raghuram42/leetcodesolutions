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
    int res;
    public int sumOfLeftLeaves(TreeNode root) {
        if(root == null)
            return 0;
        res = 0;
        dfs(root, 0);
        return res;
    }
    public void dfs(TreeNode root, int i){
        if(root == null)
            return;
        
        if(i == -1 && root.left == null && root.right == null)
            res += root.val;
        
        if(root.left != null)
            dfs(root.left, -1);
        
        
        if(root.right != null)
            dfs(root.right, 1);
        
    }
}