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
    int i;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return s(preorder, inorder, 0, inorder.length-1);
    }
    
    public TreeNode s(int[] pre, int[] in, int l, int r){
        if(i >= pre.length || l > r)
            return null;
        if(l == r){
            i++;
            return new TreeNode(in[l]);
        }
        int index= -1;
        
        for(int k=l;k<=r;k++){
            if(in[k] == pre[i])
            {
                index = k;
                break;
            }
        }
        
        
        TreeNode res = new TreeNode(pre[i++]);
        res.left = s(pre, in, l, index-1);
        res.right = s(pre, in, index+1, r);
        return res;        
        
    }
}