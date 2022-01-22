class Solution {
    int[][] dir = new int[][]{{0,1},{1,0},{-1,0},{0,-1}};
    public List<List<Integer>> highestRankedKItems(int[][] grid, int[] pricing, int[] start, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>(){
            @Override
            public int compare(int[] a, int[] b){
                if(a[0] == b[0])
                {
                    if(a[1] == b[1])
                    {
                        if(a[2] == b[2])
                        {
                            return a[3]-b[3];
                        }
                        return a[2]-b[2];
                    }
                        return a[1]-b[1];
                 }
                    
                    return a[0]-b[0];
            }
        });
        
        int dis = 0;
        Queue<int[]> q = new LinkedList<int[]>();
        q.offer(start);
        while(!q.isEmpty()){
            int sz = q.size();
            
            while(sz>0){
            int[] cur = q.poll();
               
            if(grid[cur[0]][cur[1]] == 0){
                sz--;
                continue;
            }
            
            if(grid[cur[0]][cur[1]] >= pricing[0] && grid[cur[0]][cur[1]] <= pricing[1])
                pq.offer(new int[]{dis, grid[cur[0]][cur[1]],  cur[0], cur[1]});
            
                
            
            grid[cur[0]][cur[1]] = 0;
            for(int p=0;p<4;p++){
                int x = cur[0]+dir[p][0];
                int y = cur[1]+dir[p][1];
                if(x<0 || x>=grid.length || y <0 || y >=grid[0].length || grid[x][y] == 0)
                    continue;
        
                q.offer(new int[]{x,y});
                
                
            }
                sz--;
            }
            dis++;
        }
        
        List<List<Integer>> ans= new ArrayList<>();
        
        while(k>0 && !pq.isEmpty()){
            ans.add(Arrays.asList(pq.peek()[2],pq.peek()[3]));
            pq.poll();
            k--;
        }
        
        return ans;
    }
}
