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
    int mxnum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        
        if(root == null)
            return 0;
        
        depfs(root);
        
        return mxnum;
    } 
    
    public int depfs(TreeNode root){
        
        if(root == null)
            return 0;
        
        
        int lft_max = Math.max(0, depfs(root.left)); 
        int rgt_max = Math.max(0, depfs(root.right));
        

        mxnum = Math.max(mxnum, root.val + lft_max + rgt_max);

        return  Math.max(lft_max, rgt_max)+root.val;
        
        //return mxnum;
        
    }
}