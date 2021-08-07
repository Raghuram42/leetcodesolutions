class Solution {
    public boolean sequenceReconstruction(int[] org, List<List<Integer>> seqs) {

        HashSet<Integer> orgSet = new HashSet<Integer>();
        HashSet<Integer> seqSet = new HashSet<Integer>();
        int n = org.length;
        int[] inDegree = new int[n+1];
        for(int o: org)
            orgSet.add(o);
          for(List<Integer> seq: seqs){
            for(Integer next: seq)   
                seqSet.add(next);
        }
             // System.out.println(seqSet+" "+orgSet);
        if(!seqSet.equals(orgSet))
            return false;
        boolean[][] vis = new boolean[n+1][n+1];
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        for(List<Integer> seq: seqs){
            int prev = -1;
            if(seq.size() == 1){
                  seqSet.add(seq.get(0));
                   // inDegree[seq.get(0)]++;    
            }else{
            for(Integer next: seq)   {
                seqSet.add(next);
                if(prev != -1 ){
                    // vis[prev][next] = true;
                    inDegree[next]++;    
                    if(!graph.containsKey(prev))
                        graph.put(prev, new ArrayList<Integer>());
                    
                    graph.get(prev).add(next);
                }
                // if(prev == -1)
                    prev = next;
                
            }
            }
        }
             // System.out.println(seqSet+" "+orgSet);
        if(!seqSet.equals(orgSet))
            return false;
        
        Queue<Integer> q = new LinkedList<>();
        for(int i=1;i<=n;i++)
        {
            if(inDegree[i] == 0)
                q.add(i);
            // System.out.println(inDegree[i]);
        }
        if(q.isEmpty())
            return false;
        int k = 0;
        while(!q.isEmpty()){
            // System.out.println(q);
            if(q.size() > 1 || k == n)
                return false;
            
            int curr = q.poll();
            
            if(org[k] != curr)
                return false;
            
            
            for(int i: graph.getOrDefault(curr, new ArrayList<Integer>()))
            {
                inDegree[i]=inDegree[i]-1;
                if(inDegree[i] == 0){
                    q.add(i);
                    
                }
             }
            
            k++;
        }
        
        return k == n;
            
    }
}
/*
1 -> 2
0 
    
2 
1

3
1
    
1
0
2 
0
3
1    
    */
