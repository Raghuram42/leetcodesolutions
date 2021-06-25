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
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return solve(nums, 0, nums.length-1);
    }
    
    public TreeNode solve(int[] nums, int i, int j){
        if(i>j)
            return null;
        if(i == j)
            return new TreeNode(nums[i]);
        
        int maxValInd = getMax(nums, i, j);
        
        TreeNode root = new TreeNode(nums[maxValInd]);
        
        root.left = solve(nums, i, maxValInd-1);
        root.right = solve(nums, maxValInd+1, j);
        return root;
    }
    
    
    public int getMax(int[] nums, int i, int j){
        
        
        int maxi = i;
        
        while(i<=j)
        {
            if(nums[i] > nums[maxi])
                maxi = i;
            i++;
        }
        
        return maxi;
    }
    
    
}