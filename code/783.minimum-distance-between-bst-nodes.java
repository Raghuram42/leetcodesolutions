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
    List<Integer> inorderArray;
    public int minDiffInBST(TreeNode root) {
        if(root == null)
            return 0;
        inorderArray = new ArrayList<Integer>();
        
        inorderT(root);
        int diff = Integer.MAX_VALUE;
        for(int i=1;i<inorderArray.size();i++)
            if(diff > inorderArray.get(i)-inorderArray.get(i-1))
                diff = inorderArray.get(i)-inorderArray.get(i-1);
        
        return diff;
    }
    public void inorderT(TreeNode root){
        if(root == null)
            return;
        
        inorderT(root.left);
        inorderArray.add(root.val);
        inorderT(root.right);   
    }
}