/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        if(root == null)
            return root;
        
        return lowestCommon(root, p, q);
    }
    
    public TreeNode lowestCommon(TreeNode root, TreeNode p, TreeNode q){
        if(root == null)
            return null;
        
        if(root.val == p.val)
            return root;
        
        
        if(root.val == q.val)
            return root;
        
        TreeNode p1 = lowestCommon(root.left, p, q);
        TreeNode p2 = lowestCommon(root.right, p, q);
        
        if((p1 != null && p2 != null))
            return root;
        
        if(p1 == null)
            return p2;
        
        return p1;    
        
        
    }
}