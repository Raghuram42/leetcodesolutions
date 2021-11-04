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
    boolean lef = false;
    int ans = 0;
    public int sumOfLeftLeaves(TreeNode root) {
        if(root == null)
            return ans;
        
        if(lef && root.left == null && root.right == null)
        {
            ans += root.val;
            return ans;
        }
        lef = true;
        sumOfLeftLeaves(root.left);
        lef = false;
        sumOfLeftLeaves(root.right);
        return ans;
    }
}
