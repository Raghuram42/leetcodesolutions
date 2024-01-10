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
    HashMap<Integer, List<Integer>> graph;
    HashSet<Integer> vis;
    public int amountOfTime(TreeNode root, int start) {
        graph = new HashMap<Integer, List<Integer>>();
        vis = new HashSet<>();
        
        solve(root, null);
        
        return getTime(start);
    }
    
    public void solve(TreeNode root, TreeNode parent){
        if(root == null)
            return;
        
        if(!graph.containsKey(root.val))
            graph.put(root.val, new ArrayList<Integer>());
        
        
        
        if(parent != null){
         graph.get(root.val).add(parent.val);
            
            
        if(!graph.containsKey(parent.val))
            graph.put(parent.val, new ArrayList<Integer>());
            
            
            graph.get(parent.val).add(root.val);
        }
        
        solve(root.left, root);
        solve(root.right, root);
        
    }
    
    public int getTime(int st){
        
        if(!graph.containsKey(st))
            return 0;
        
        vis.add(st);
        
        Queue<Integer> q = new LinkedList<>();
        
        q.offer(st);
        
        int ans = -1;
        
        while(!q.isEmpty()){
            // System.out.println(q+" "+vis);
            int sz = q.size();
            while(sz>0){
            int curr = q.poll();
            for(int next: graph.getOrDefault(curr, new ArrayList<Integer>())){
                if(!vis.contains(next)){
                     q.offer(next);
                     vis.add(next);
                }
            }
                sz--;
            }
            ans++;
        }
        return ans;
    }
}