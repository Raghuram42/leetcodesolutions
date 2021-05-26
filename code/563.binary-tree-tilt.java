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
    int ans;
    public int findTilt(TreeNode root) {
        ans = 0;
        solve(root, 0);
        return ans;
    }
    public int solve(TreeNode root, int totalsum){
        if(root == null)
            return 0;
        
        
        int lft = solve(root.left, totalsum);
        int rgt = solve(root.right, totalsum);
        
        totalsum = root.val+lft+rgt;
        root.val = Math.abs(lft-rgt);
        ans += root.val;
        return totalsum;
    }
}