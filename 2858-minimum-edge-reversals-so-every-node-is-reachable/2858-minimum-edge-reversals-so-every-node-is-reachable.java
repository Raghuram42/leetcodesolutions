class Solution {
    class Node{
        int u;
        int v;
        int i;
        Node(int u, int v, int i){
            this.u = u;
            this.v = v;
            this.i = i;
        }
        
        @Override
        public String toString(){
            return this.u+" "+this.v+" "+this.i;
        }
    }
    HashMap<Integer, List<Node>> g;
    Integer[][] dp;
    int[] res;
    public int[] minEdgeReversals(int n, int[][] edges) {
        g = new HashMap<>();
        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
        dp = new Integer[n][3];
        for(int[] e: edges){
            if(!g.containsKey(e[0])){
                g.put(e[0], new ArrayList<Node>());
                map.put(e[0], new HashSet<>());
            }
            g.get(e[0]).add(new Node(e[0], e[1], 0));
            map.get(e[0]).add(e[1]);
        }
        for(int[] e: edges){
            int u = e[0];
            int v = e[1];
            // System.out.println(map.get(v)+" "+u+);
            if(map.containsKey(v) && map.get(v).contains(u))
                continue;
                
                if(!g.containsKey(v))
                    g.put(v, new ArrayList<Node>());
            
                g.get(v).add(new Node(v, u, 1));
            }
        
        // for(int k: g.keySet())
        // {
        //     Collections.sort(g.get(k), (a, b)->a.i-b.i);
        // }
        res = new int[n];
                
        s(0, 0, -1);
        s2(0, -1);
        
        return res;
    }
    
    public int s(int i, int d, int p){
        
        if(!g.containsKey(i))
            return 0;
        
        int ans = 0;
        for(Node next: g.getOrDefault(i, null)){
            if(next.v == p)
                continue;
            ans += (next.i)+s(next.v, next.i, i);
        }
        // System.out.println(i+" "+d+" "+ans);
        return res[i] = ans;
        // return dp[i][d] = ans;
    }
    
    
    public void s2(int i, int p){
        
        if(!g.containsKey(i))
            return;
        
        int ans = 0;
        for(Node next: g.getOrDefault(i, null)){
            if(next.v == p)
                continue;
            
            res[next.v] = res[i];
            if(next.i == 1)
                res[next.v]--;
            else
                res[next.v]++;
            
            s2(next.v, i);
        }
        
    }
}