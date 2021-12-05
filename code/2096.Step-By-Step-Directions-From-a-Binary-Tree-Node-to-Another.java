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
    class Pair{
        int val;
        char orient;
        
        Pair(int val, char orient){
            this.val = val;
            this.orient = orient;
        }
        
        @Override
        public String toString(){
            return this.val+" dir "+this.orient;
        }
        
    }
    
    class Pair2{
        int val;
        StringBuilder s;
        
        Pair2(int val, StringBuilder s){
            this.val = val;
            this.s = s;
        }
        
        @Override
        public String toString(){
            return this.val+" dir "+this.s.toString();
        }
        
        
    }
    HashMap<Integer, List<Pair>> graph;
    StringBuilder res;
    public String getDirections(TreeNode root, int startValue, int destValue) {
        graph = new HashMap<>();
        res = new StringBuilder();
        dfs(root);
        
        Queue<Pair2> q = new LinkedList<>();
        
        
        // q.offer(new Pair2(startValue, new StringBuilder()));
        
        HashSet<Integer> vis = new HashSet<>();
//         while(!q.isEmpty()){
            
//             Pair2 curr = q.poll();
//             if(vis.contains(curr.val))
//                 continue;
            
//             if(curr.val == destValue)
//                 return curr.s;
//             vis.add(curr.val);
//             for(Pair next: graph.get(curr.val)){
//                 if(!vis.contains(next.val))
//                     q.offer(new Pair2(next.val, curr.s+next.orient));
//             }
            
            
//         }
        
        
        dfs2(startValue, destValue, vis);
        
        return res.reverse().toString();
        
        
    }
    public boolean dfs2(int s, int d, HashSet<Integer> vis){
        if(s == d)
            return true;
        if(vis.contains(s))
            return false;
        vis.add(s);
        for(Pair next : graph.get(s)){
            if(!vis.contains(next.val) && dfs2(next.val, d, vis))
            {
                res.append(next.orient);
                return true;
            }
        }
        
        return false;
    }
    public void dfs(TreeNode root){
        if(root == null)
            return;
        
        if(!graph.containsKey(root.val))
            graph.put(root.val, new ArrayList<Pair>());
        
        
        
        if(root.left != null && !graph.containsKey(root.left.val))
            graph.put(root.left.val, new ArrayList<Pair>());
               

        
        
        
        if(root.right != null && !graph.containsKey(root.right.val))
            graph.put(root.right.val, new ArrayList<Pair>());
         
        
        if(root.left != null)
        {
            graph.get(root.val).add(new Pair(root.left.val, 'L'));
            graph.get(root.left.val).add(new Pair(root.val, 'U'));
        }
        
        
        
        if(root.right != null)
        {
            graph.get(root.val).add(new Pair(root.right.val, 'R'));
             graph.get(root.right.val).add(new Pair(root.val, 'U'));
        }
           
        dfs(root.left);
        dfs(root.right);
        
    }
}
