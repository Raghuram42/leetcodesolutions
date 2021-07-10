class Solution {
    int[][] dir = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
    public int nearestExit(char[][] maze, int[] entrance) {
        if(maze[entrance[0]][entrance[1]] == '+')
            return -1;
        int n = maze.length;
        int m = maze[0].length;
        Queue<int[]> q = new LinkedList<int[]>();
        
        q.offer(entrance);
        int res = 0;
        while(!q.isEmpty()){
            int sz = q.size();
            
            while(sz>0){
                
                int[] curr = q.poll();
                // System.out.println((entrance[0]+"$"+entrance[1] +" diff "+ curr[0]+"$"+curr[1])+" "+isInBorder(curr, n, m));
                if(!(entrance[0]+"$"+entrance[1]).equals(curr[0]+"$"+curr[1]) && isInBorder(curr, n, m))
                    return res;
                
                for(int d=0;d<4;d++)
                {
                    int x = curr[0]+dir[d][0];
                    int y = curr[1]+dir[d][1];
                    
                    if(x<0 || y<0 || x >=n || y >= m || maze[x][y] == '+')
                        continue;
                    
                    q.offer(new int[]{x,y});
                    maze[x][y] = '+';
                }
                
                sz--;
            }
            // System.out.println(q);
            res++;
        }
        
        return -1;
    }
    
    public boolean isInBorder(int[] curr, int n, int m){
        if(curr[0] == n-1 || curr[1] == m-1 || curr[1] == 0 || curr[0] == 0)
            return true;
        
        return false;
    }
}
