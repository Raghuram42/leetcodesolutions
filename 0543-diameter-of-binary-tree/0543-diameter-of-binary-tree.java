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
    int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        s(root);
        return max;
    }
    
    public int s(TreeNode r){
        if(r == null)
            return 0;
        
        int left = s(r.left);
        int right = s(r.right);
        
        max = Math.max(max, left+right);
        return 1+Math.max(left, right);
    }
}