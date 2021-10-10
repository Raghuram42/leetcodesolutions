class Solution {
    public int minOperations(int[][] grid, int x) {
        List<Integer> list = new ArrayList<>();
        int m = grid.length;
        int n = grid[0].length;
      
        for(int[] g: grid)
            for(int next: g)
                list.add(next);
      
        Collections.sort(list);
        int mid = list.get((m*n)/2);
        
        int min = 0;
        
        for(int next: list){
            if(Math.abs(next-mid)%x != 0)
                return -1;
            
            min += Math.abs(next-mid)/x; 
        }
        
        return min;
    }
}
