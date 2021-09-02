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
    List<TreeNode> res;
    public List<TreeNode> generateTrees(int n) {
        res = new ArrayList<TreeNode>();
        return solve(1, n);
    }
    
    public List<TreeNode> solve(int curr, int max){
        List<TreeNode> res = new ArrayList<TreeNode>();
        if(curr > max){
            res.add(null);
            return res;
        }
        
        
        for(int i=curr;i<=max;i++){

                List<TreeNode> left = solve(curr, i-1);          

                List<TreeNode> right = solve(i+1, max);          
                
                for(TreeNode l: left){
                    for(TreeNode r: right){
                        TreeNode cur = new TreeNode(i);
                        
                        cur.left = l;
                        cur.right = r;
                        
                        res.add(cur);
                    }
                }
            

        }
        
        return res;
    }
    
    public TreeNode clone(TreeNode root){
        if(root == null)
            return root;
        
        TreeNode cloned = new TreeNode(root.val);
        cloned.left = clone(root.left);
        cloned.right = clone(root.right);
        return cloned;
        
    }
}
