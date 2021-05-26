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
    public TreeNode convertBST(TreeNode root) {
        if(root == null)
            return root;
        solve(root, 0);
        return root;
  
    }
    public int solve(TreeNode root, int sum){
        if(root == null)
            return sum;
        
        sum = solve(root.right, sum);
        
        root.val += sum;
        sum = root.val;
        sum = solve(root.left, sum);
        
        return sum;
        
        
    }
}