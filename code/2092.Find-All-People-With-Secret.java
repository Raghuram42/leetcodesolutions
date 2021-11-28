class Solution {
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        int m = meetings.length;
        
        boolean[] secretKnown = new boolean[n];
        int t = 1;
        int i = 0;
        secretKnown[0] = true;
        secretKnown[firstPerson] = true;
        Arrays.sort(meetings, (a,b)->a[2]-b[2]);//Sort the inp according thier time
        while(t<100000 && i<m){
            HashMap<Integer, List<Integer>> graph = new HashMap<Integer, List<Integer>>();
            
            while(i<m && meetings[i][2] <= t){//Create a graph less than curr t time
                
                if(!graph.containsKey(meetings[i][0]))
                    graph.put(meetings[i][0], new ArrayList<Integer>());
                
                
                if(!graph.containsKey(meetings[i][1]))
                    graph.put(meetings[i][1], new ArrayList<Integer>());
                
                graph.get(meetings[i][0]).add(meetings[i][1]);
                graph.get(meetings[i][1]).add(meetings[i][0]);
                i++;
            }
            boolean[] vis = new boolean[n];
            for(int next: graph.keySet())
                dfs(graph, secretKnown, next, vis);//Do dfs on connected graph components and update secretKnown accordingly
            
            t++;
            
        }
        List<Integer> res = new ArrayList<>();
        
        for(i=0;i<n;i++)
            if(secretKnown[i])
                res.add(i);
        
        return res;
    }
    
    public void dfs(HashMap<Integer, List<Integer>> g, boolean[] sec, int curr, boolean[] vis){
        if(!sec[curr])
            return;
        if(vis[curr])
            return;
        vis[curr] = true;
        for(int next: g.get(curr))
        {
            sec[next] = true;
            if(!vis[next])
                dfs(g, sec, next, vis);
        }
    }
}
