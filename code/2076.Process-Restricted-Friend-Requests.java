class Solution {
    public boolean[] friendRequests(int n, int[][] restrictions, int[][] requests) {
        int m = requests.length;
        boolean[] res = new boolean[m];
        UnionFind unf = new UnionFind(n);
        for(int i=0;i<m;i++)
            unf.union(requests[i][0], requests[i][1], restrictions, i, res);
        
        return res;
    }
    
    class UnionFind{
        int[] par;
        int[] rank;
        UnionFind(int n){
            this.par = new int[n];
            this.rank = new int[n];
            Arrays.fill(par, -1);
        }
        
        
        public int find(int x){
            
            if(par[x] != -1 && x != par[x])
                return find(par[x]);
            
            return par[x] = x;
        }
        
        public void union(int x, int y, int[][] restrictions, int i, boolean[] res){
            int px = find(x);
            int py = find(y);
            
            int prevX = px;
            int prevY = py;
            int prevrankX = rank[px];
            int prevrankY = rank[py];
              if(rank[px] > rank[py]){
                  par[py] = px; 
              }else{
                  par[px] = py;
                  rank[py]++;
              }
            boolean directFr = true;
           for(int[] r: restrictions){
               int p1 = find(r[0]);
               int p2 = find(r[1]);
               
               
               if(p1 == p2){
                   directFr = false;
                   break;
               }
               
           }
            
            
           res[i] = directFr; 
            
          if(!res[i]){
              par[px] = px;
              par[py] = py;
              rank[px] = prevrankX;
              rank[py] = prevrankY;
              
          } 
        }
        
    }
}
