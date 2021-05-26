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
    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        List<Integer> res = new ArrayList<>();
        i =0 ;
        boolean ans = solve(root, voyage, res);
        
        return ans ? Arrays.asList(-1) : res;
    }
    
    public boolean solve(TreeNode root, int[] v, List<Integer> red){
        if(root != null){
            if(root.val != v[i]){
                // System.out.println(root.val+" "+v[i]);
                return true;
            }
            i++;
            if(root.left != null && root.right != null && root.left.val != v[i] )
            {
                TreeNode tmp = root.right;
                root.right = root.left;
                root.left = tmp;
                red.add(root.val);
                   // System.out.println(root.left.val+" "+v[i]+" "+red);
            }
            
            if(solve(root.left, v, red) || solve(root.right, v, red))
                return true;
            
        }
        return false;
    }
}