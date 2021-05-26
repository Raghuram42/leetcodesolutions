class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        
        ArrayList<Integer> res = new ArrayList<Integer>();
        if (edges.length == 0) {
            res.add(0);
            return res;
        } 
        HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>();
        
        for(int i=0;i<n;i++)
            graph.put(i, new ArrayList<Integer>());
        
        int[] degr = new int[n];
        for(int i=0;i<edges.length;i++){
            graph.get(edges[i][0]).add(edges[i][1]);
            graph.get(edges[i][1]).add(edges[i][0]);
            degr[edges[i][0]]++;
            degr[edges[i][1]]++;
        }
        
        
        Queue<Integer> que = new LinkedList<Integer>();
        
        for(int i=0;i<n;i++)
            if(degr[i] == 1)
                que.offer(i);
        
        int c =0;
        while(!que.isEmpty()){
            
            int sz = que.size();
            c+=sz;
            
            for(int i=0;i<sz;i++){
                Integer id = que.poll();
                degr[id]--;
                
                  if (c == n) res.add(id);
                for (Integer adjId : graph.get(id)) {

                    if (degr[adjId] != 0) {
                        degr[adjId]--;
                        if (degr[adjId] == 1) que.offer(adjId);
                    }
                }
            }
            }
        return res;
        }
    
    }