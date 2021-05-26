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
        int maxdiff;
   public  int maxAncestorDiff(TreeNode root) {
        if (null == root) return 0;
        maxdiff = 0;
        dfs(root, root.val, root.val);
        return maxdiff;
    }

    public  void dfs(TreeNode root, int min, int max) {
        if (root == null) return;
        /**
         * Compute the difference with the root
         * */
        int diff1 = Math.abs(root.val - min);
        int diff2 = Math.abs(root.val - max);
        /**
         * find the max difference from those value
         * */
        maxdiff = Math.max(maxdiff, diff1);
        maxdiff = Math.max(maxdiff, diff2);
        /**
         * do dfs in both trees
         * */
        dfs(root.left, Math.min(min, root.val), Math.max(max, root.val));
        dfs(root.right, Math.min(min, root.val), Math.max(max, root.val));
    }
}