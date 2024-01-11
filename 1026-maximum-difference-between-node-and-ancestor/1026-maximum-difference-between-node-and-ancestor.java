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
    public int maxAncestorDiff(TreeNode root) {
        return s(root, Integer.MAX_VALUE, Integer.MIN_VALUE);
    }
    public int s(TreeNode r, int min, int max){
        if(r == null)
            return max-min;
        
        min = Math.min(min, r.val);
        max = Math.max(max, r.val);
        
        return Math.max(s(r.left, min, max), s(r.right, min, max));
    }
}