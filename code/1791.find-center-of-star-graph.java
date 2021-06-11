class Solution {
    public int findCenter(int[][] edges) {
        HashMap<Integer, List<Integer>> graph = new HashMap<Integer, List<Integer>>();
        
        int center = -1;
        int maxchilds = 0;
        for(int[] edge: edges){
            if(!graph.containsKey(edge[0]))
                graph.put(edge[0], new ArrayList<Integer>());
                
            if(!graph.containsKey(edge[1]))    
                graph.put(edge[1], new ArrayList<Integer>());
            
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
            
            if(graph.get(edge[0]).size() > maxchilds){
                maxchilds = graph.get(edge[0]).size();
                center = edge[0];
            }
            
            
            
            if(graph.get(edge[1]).size() > maxchilds){
                maxchilds = graph.get(edge[1]).size();
                center = edge[1];
            }
        }
        
        return center;
    }
}