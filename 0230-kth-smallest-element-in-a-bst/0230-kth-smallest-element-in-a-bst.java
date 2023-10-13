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
    int p;
    public int kthSmallest(TreeNode root, int k) {
        p = k;
        return s(root);
    }
    
    public int s(TreeNode root){
        if(root == null)
            return -1;
        int ans = s(root.left);
        if(p > 0 )
        p--;
        else {
            // System.out.println(p+" "+ans);
            return ans;
        }
        if(p == 0)
            return root.val;
        
        ans = s(root.right);
        
        return ans;
    }
}