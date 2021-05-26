class Solution {
    int[] vis;
    public boolean isBipartite(int[][] graph) {
        HashMap<Integer, ArrayList<Integer>> hsm = new HashMap<Integer, ArrayList<Integer>>();
        vis = new int[graph.length];

        for(int i=0;i<graph.length;i++){
            hsm.put(i, new ArrayList<Integer>());
            for(int j=0;j<graph[i].length;j++)
                  hsm.get(i).add(graph[i][j]);
        }
        
        int[] setA = new int[graph.length];
        int[] setB = new int[graph.length];

        boolean res = true;
        for(int i=0;i<graph.length;i++)
           if(vis[i] == 0)
            dfs(hsm, i, setA, setB, true);
        
        for(int i=0;i<graph.length;i++)
           if(setA[i]==setB[i])
               return false;

        return res;
    }
    public void dfs( HashMap<Integer, ArrayList<Integer>> hsm, int i, int[] setA, int[] setB, boolean fro){
        
    
        if(fro)
        setA[i] = 1;
        else
        setB[i] = 1;
            
        if(vis[i] == 1)
            return;
        vis[i] = 1;
        ArrayList<Integer> curr = hsm.get(i);
        
        if(curr == null)
            return;

        for(int c: curr){
           if(fro)
            setB[c] = 1;  
            else
            setA[c] = 1;
        //    System.out.println(c+" "+i+" "+fro);
        dfs(hsm, c, setA, setB, !fro);
        }
    }
}