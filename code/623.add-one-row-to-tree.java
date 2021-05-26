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
    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if(root == null)
            return null;
        
        if(d == 1)
        {
            TreeNode tmp =new TreeNode(v);
            tmp.left = root;
            return tmp;
        }
        if(d-1 == 1){
            TreeNode left = root.left;
            TreeNode right = root.right;
            
            root.left = new TreeNode(v);
            root.right = new TreeNode(v);
            
            root.left.left =left;
            root.right.right = right;
            
            return root;
        }
        
        root.left = addOneRow(root.left, v, d-1);
        root.right = addOneRow(root.right, v, d-1);
        
        return root;
        
    }

}