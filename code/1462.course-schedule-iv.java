class Solution {
    ArrayList<Set<Integer>> ed;
    HashMap<String, Boolean> vis;
    public List<Boolean> checkIfPrerequisite(int n, int[][] prerequisites, int[][] queries) {
        List<Boolean> res = new ArrayList<Boolean>();  
        if(n == 1 || prerequisites.length < 1)
        {
            for(int[] a : queries){
            res.add(false);
            }
            return res;
        }
        
          ArrayList<Set<Integer>> edg = new ArrayList<Set<Integer>>();

          vis = new HashMap<String, Boolean>();

        for(int i=0;i<n;i++)
            edg.add(new HashSet<Integer>());
        
        
        for(int[] a : prerequisites)
            edg.get(a[0]).add(a[1]);
      
        ed = edg;
        
        int[] mpr = new int[n];
        int p = 0;
        
        
        for(int i=0;i<queries.length;i++){
           res.add(traverse(i, queries[i][0], queries[i][1]));
        }
       return res;
        
    }
    
    
    public boolean traverse(int i, int frm, int to){
        String k = Integer.toString(frm) + "$" + Integer.toString(to);
        
        if(vis.containsKey(k)){
            return vis.get(k);
        }
        
        if(ed.get(frm).contains(to)){
            vis.put(k, true);
            return true;
        }
        
        for(int a : ed.get(frm)){
            
            if(traverse(i, a, to)){
                vis.put(k, true);
                return true;
            }
            else{
                vis.put(k, false);
            }
        }
        if(!vis.containsKey(k)){
        vis.put(k, false);
        }
        return vis.get(k);
    }
}