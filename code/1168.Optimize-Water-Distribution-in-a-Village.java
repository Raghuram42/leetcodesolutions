class Solution {
    int[] parent;
    int[] ranks;
    public int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {
         PriorityQueue<int[]> pq = new PriorityQueue<int[]>( new Comparator<int[]>(){
             @Override
             public int compare(int[] a, int[] b){
                 return a[2]-b[2];
             }
         });
        n = wells.length+1;
        int i = 1;
        for(int well: wells)
            pq.offer(new int[]{i++, n, well});
        
        for(int[] pipe: pipes)
            pq.offer(pipe);
        
        parent = new int[n+1];
        for( i=0;i<=n;i++)
            parent[i] = i;
        
        ranks = new int[n+1];
        int res = 0;
        
        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            
            if(!unionSet(curr[0], curr[1]))
                res += curr[2];
            
        }
        return res;
        
    }
    public boolean unionSet(int n, int m){
        int p1 = find(n);
        int p2 = find(m);
        if(p1 == p2)
            return true;
        
        if(ranks[p1] > ranks[p2]){
            parent[p2] = p1;
        }else{
            parent[p1] = p2;
            if(ranks[p1] == ranks[p2])
                ranks[p2]++;
            
        }
        
        return false;
    }
    
    public int find(int n){
        
        if(n != parent[n])
            return parent[n] = find(parent[n]);
        return parent[n];
    }
}
