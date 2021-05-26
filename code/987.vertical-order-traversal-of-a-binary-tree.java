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
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> res  = new TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>>();
        if(root == null)
            return new ArrayList<List<Integer>>();
        res = dfs(root, res, 0, 0);
      //  System.out.println(res);
        ArrayList<List<Integer>> ress = new ArrayList<List<Integer>>();
        
        for(TreeMap<Integer, PriorityQueue<Integer>> pq: res.values()){
            int sz = ress.size();
            ress.add(new ArrayList<Integer>());
            for(PriorityQueue<Integer> q: pq.values()){
            while(q.size() > 0){
             ress.get(sz).add(q.poll());
                }
            }
        }
        
        return ress;
        
    }
    
    public TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> dfs(TreeNode root, TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> res, int maxdep, int lev){
        if(root == null)
             return res;
       
        if(!res.containsKey(maxdep))
           res.put(maxdep, new TreeMap<Integer, PriorityQueue<Integer>>());
        if(!res.get(maxdep).containsKey(lev))
            res.get(maxdep).put(lev,  new PriorityQueue<Integer>());
        
        res.get(maxdep).get(lev).offer(root.val);
        
        dfs(root.left, res, maxdep-1, lev+1);
        dfs(root.right, res,  maxdep+1, lev+1);
        
        
        return res;
        
    }
    
        
}