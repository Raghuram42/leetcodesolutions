class Solution {
    public int largestMagicSquare(int[][] grid) {
        int res= 1;
        int min = Math.min(grid.length, grid[0].length);
        int i=0;
        for(i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                for(int k=1;k<min;k++){
                    if(i+k < grid.length && j+k< grid[0].length && magicSquare(grid, i,j, k))
                        res = Math.max(k+1, res);
                }
            }
        }
        
        return res;
    }
    
    
    public boolean magicSquare(int[][] grid, int st, int end, int dis){
        dis += 1;
        long prevsum = Long.MIN_VALUE;
        long rowsum = 0;
        long colsum = 0;
        for(int i=st;i<st+dis;i++){
            for(int j=end;j<end+dis;j++){
                rowsum += grid[i][j];
            }
            // System.out.println(rowsum+" "+st+" r "+end+" "+dis);
            if(prevsum != Long.MIN_VALUE && (prevsum != rowsum ))
                return false;
            
            prevsum = rowsum;
            rowsum=0;
        }
        
        
        for(int i=end;i<end+dis;i++){
            for(int j=st;j<st+dis;j++){
                colsum += grid[j][i];
            }
            // System.out.println(colsum+" "+st+" c "+end+" "+dis+" "+prevsum);
            if(prevsum != colsum)
                return false;
            
            prevsum = colsum;
            colsum =0;
        }
        
        long diagsum = 0;
        long revdiagsum = 0;
        
        int i=st;
        int j=end;
        while(i<st+dis && j<end+dis){
            diagsum += grid[i][j];   
            i++;
            j++;
        }
        i= st;
        j=end+dis-1;
        // System.out.println(diagsum+" "+st+" d "+end+" "+dis+" "+prevsum);
        if(diagsum != prevsum)
            return false;
        
        while(i<st+dis && j>=0){
            revdiagsum += grid[i][j];
            i++;
            j--;
        }
        // System.out.println(revdiagsum+" "+st+" rd "+end+" "+dis+" "+prevsum);
        if(revdiagsum != diagsum)
            return false;
        return true;
        
    }
}