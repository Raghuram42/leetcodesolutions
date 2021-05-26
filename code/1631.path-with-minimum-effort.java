class Solution {
    HashMap<Integer, List<Height>> graph;
    int[][] dir = new int[][]{{1,0},{-1,0},{0,-1},{0,1}};
    int res;
    int[] vis;
    int noofitr;
    public int minimumEffortPath(int[][] heights) {
         graph = new HashMap<Integer, List<Height>>();
         Height[][] heig = new Height[heights.length][heights[0].length];
        vis = new int[heights.length * heights[0].length];
        noofitr = 0;
        Arrays.fill(vis, Integer.MAX_VALUE);
        
         int i = 0;
         for(int p=0;p<heights.length;p++){
             for(int q=0;q<heights[0].length;q++){
             heig[p][q] = new Height(heights[p][q], i++);
                 }
         }
        
        res = Integer.MAX_VALUE;
         for(int p=0;p<heights.length;p++){
             for(int q=0;q<heights[0].length;q++){
                 if(!graph.containsKey(heig[p][q].i))
                     graph.put(heig[p][q].i, new ArrayList<Height>());
                 
                 for(i=0;i<4;i++){
                     int x = p+dir[i][0];
                     int y = q+dir[i][1];
                     
                     if(x<0||y<0||x>=heights.length||y>=heights[0].length)
                         continue;
                     
                     graph.get(heig[p][q].i).add(new Height(Math.abs(heig[p][q].height-heig[x][y].height), heig[x][y].i)) ;
                 }
             }
         }
        
        Queue<Integer> q = new LinkedList<Integer>();
        vis[0] = 0;
        q.offer(0);
        
        
        while(!q.isEmpty()){
          int currind = q.poll();
            
            for(Height h: graph.get(currind)){
                int currc = Math.max(h.height, vis[currind]);
                if(currc < vis[h.i]){
                    vis[h.i] = currc;
                    q.offer(h.i);
                }
                
            }
        }
        
        return vis[vis.length-1];
    }
    
    class Height{
        int height;
        int i;
        
        Height(int height, int i){
            this.height = height;
            this.i  = i;
        }
    }
    
//     public void dfs(int i, int currheight){
//         noofitr++;
//         if(i == vis.length-1){
//             // System.out.println(res+" "+currheight+" "+i);
//             res = Math.min(currheight, res);
            
//             return;
//         }
//         if(vis[i] != -1)
//             return;
//         List<Height> curr = graph.get(i);
//         vis[i] = 1;
//         if(curr == null)
//             return;
//         for(Height cu: curr){
//             if(cu.i != i)
//             dfs(cu.i, Math.max(currheight, cu.height));
//         }
//         vis[i] = -1;
//     }
}