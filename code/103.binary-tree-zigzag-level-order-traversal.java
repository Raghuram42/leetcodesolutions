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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(root == null)
            return res;
        zigzag(root, res, 0, 0);
        return res;
    }
    
    public void zigzag(TreeNode root, List<List<Integer>> res, int way, int ind){
        if(root == null)
            return;
        ArrayList<Integer> tmp = new ArrayList<Integer>();
        if(res.size() == ind)
            res.add(ind, new ArrayList<Integer>());
        if(way == 0){
          res.get(ind).add(root.val);
          way = 1; 
        }else{
            way = 0;
            res.get(ind).add(0, root.val);
        }
        zigzag(root.left, res, way,ind+1);
        zigzag(root.right, res, way,ind+1);
        
    }
}