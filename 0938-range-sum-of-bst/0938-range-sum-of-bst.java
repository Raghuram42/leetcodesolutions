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
    public int rangeSumBST(TreeNode root, int low, int high) {
        if(root == null)
            return 0;
            
        int sum = root.val >= low && root.val <= high ? root.val : 0;
        
        int leftSum = root.val <= low ? 0 : rangeSumBST(root.left, low, high);  
        int rightSum = root.val >= high ? 0 : rangeSumBST(root.right, low, high);
        return sum + leftSum+rightSum;
            
    }
}