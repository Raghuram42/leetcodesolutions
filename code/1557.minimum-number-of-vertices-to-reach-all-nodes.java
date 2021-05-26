class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        int[] indeg = new int[n];
        
        for(List<Integer> edg: edges)
            indeg[edg.get(1)]++;
        
        List<Integer> res = new ArrayList<Integer>();
        
        for(int i=0;i<n;i++)
            if(indeg[i] == 0)
                res.add(i);
        
        return res;
    }
}