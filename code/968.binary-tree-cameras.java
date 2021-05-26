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
    int res = 0;
    public int minCameraCover(TreeNode root) {
        if(root == null)
            return 0;
        if(root.left == null && root.right == null)
            return 1;
        return minCamera(root) == 0 ? res+1: res;
    }
    
    public int minCamera(TreeNode root){
        if(root == null)
            return 1;
        int dc1 = minCamera(root.left);
        int dc2 = minCamera(root.right);
        
        if(dc1 == 0 || dc2 == 0)
        {
            res++;
            return 2;
        }
        
        if(dc1 == 1 && dc2 == 1)
            return 0;
        
        return 1;
        
    }
}