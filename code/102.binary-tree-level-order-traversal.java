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
class Pair{
    TreeNode root;
    int ind;
    Pair(TreeNode root, int ind){
        this.root = root;
        this.ind = ind;
    }
}

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
     if(root == null)
         return res;
       
        
        Queue<Pair> que = new LinkedList<Pair>();
        que.offer(new Pair(root, 0));
        
        
        while(!que.isEmpty()){
            Pair tnp = que.poll();
        
            if(res.size() < tnp.ind+1)
                res.add(new ArrayList<Integer>());
            
            
            res.get(tnp.ind).add(tnp.root.val);
            
            if(tnp.root.left != null)
                que.offer(new Pair(tnp.root.left, tnp.ind+1));
            
            
            if(tnp.root.right != null)
                que.offer(new Pair(tnp.root.right, tnp.ind+1));
            
        }
        
        return res;
        
        
        
        
    }
    
//     public void dfs(List<List<Integer>> res, TreeNode root, int ind){
//         if(root  == null)
//             return;
        
        
//         res.get
//     }
}