class Solution {
    class Node{
        int cost;
        int i;
        int mask;
        
        public Node(int cost, int i, int mask){
            this.cost = cost;
            this.i = i;
            this.mask = mask;
        }
    }
    public int shortestPathLength(int[][] graph) {
        HashSet<Pair<Integer, Integer>> set = new HashSet<>();
        
        int n = graph.length;
        
        
        Queue<Node> q = new LinkedList<>();
        
        for(int i=0;i<n;i++)
        {
            q.add(new Node(0, i, (1<<i)));
            set.add(new Pair<>(i, (1<<i)));
        }
        
        while(!q.isEmpty()){
            Node cur = q.poll();
            
            if(cur.mask == ((1<<n)-1))
                return cur.cost;
            
            for(int next: graph[cur.i]){
                int nextMask = cur.mask | (1<<next);
                if(!set.contains(new Pair<>(next, nextMask))){
                    set.add(new Pair<>(next, nextMask));
                    q.add(new Node(1+cur.cost, next, nextMask));
                }
            }
        }
        
        return 0;
    }
}