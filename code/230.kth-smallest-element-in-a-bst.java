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
    int ans;
    public int kthSmallest(TreeNode root, int k) {
        ans = k;
     return  ktraverse(root);
        
        
    }
    
    public int ktraverse(TreeNode root){
        if(root == null)
             return -1;
       // System.out.println(root.val+" "+k+" "+i);

        int res = ktraverse(root.left);
        if(res != -1){
            return res;
        }
        
        if(--ans == 0){
            return root.val;
        }
        
        return ktraverse(root.right);
    }
}