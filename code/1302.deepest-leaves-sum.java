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
    public int deepestLeavesSum(TreeNode root) {
        int maxdep = solve(root);
        ans = 0;
        solve2(root, 0, maxdep);
        return ans;
    }
    
    public int solve(TreeNode root){
        if(root == null)
            return 0;
        
        return 1+Math.max(solve(root.left), solve(root.right));
    }
    public void solve2(TreeNode root, int dep, int maxdep){
        if(root == null)
            return;
        
        if(root.left == null && root.right == null && dep+1 == maxdep)
        {
            ans += root.val;
            return;
        }
        solve2(root.left, dep+1, maxdep);
        solve2(root.right, dep+1, maxdep);
    }
}