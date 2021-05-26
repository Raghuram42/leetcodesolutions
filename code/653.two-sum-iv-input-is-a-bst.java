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
    HashSet<Integer> hst;
    public boolean findTarget(TreeNode root, int k) {
      hst = new HashSet<Integer>();
        
        return traverse(root, k);
    }
    public boolean traverse(TreeNode root, int k){
        
        if(root == null)
            return false;
        
        if(hst.contains(k-root.val))
            return true;
        hst.add(root.val);
        
//         if(k-root.val <= root.val)
//         return traverse(root.left, k) ;
            
        return traverse(root.left, k) || traverse(root.right, k);   
    }
}