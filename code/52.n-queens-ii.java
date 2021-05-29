class Solution {
    int res;
    public int totalNQueens(int n) {
        char[][] b = new char[n][n];
        res = 0;
        for(int i=0;i<n;i++)
            Arrays.fill(b[i], '.');
        
               
                    solve(0, 0, b, n);
        
        return res;
    }
    
    
    public void solve(int i, int j, char[][] b, int n){
        
        if(n == 0){
            res++;
            return;
        }
        if(i>= b.length && j>=b.length)
            return;
        for(int k=0;k<b.length;k++){
            if(safe(i, k, b)){
                b[i][k] = 'Q';
                // for(int l=0;l<b.length;l++)
                solve(i+1, 0, b, n-1);
                b[i][k] = '.';
            }
        }
        
        
    }
    
    
    public boolean safe(int i, int j, char[][] b){
        
        int row = 0;
        
        while(row <b.length){
            if(b[row][j] == 'Q')
                return false;
            row++;
        }
        
        int col = 0;
        
        while(col < b.length){
            if(b[i][col] == 'Q')
                return false;
            col++;
        }
        
        col = j;
        row = i;
        
        while(row < b.length && col < b.length){
            if(b[row][col] == 'Q')
                return false;
            
            col++;
            row++;
        }
        
        row = i;
        col = j;
        while(row >=0 && col >=0){
            if(b[row][col] == 'Q')
                return false;
            
            col--;
            row--;
        }
        
        
        row = i;
        col = j;
        
        while(row >=0 && col <b.length){
            if(b[row][col] == 'Q')
                return false;
            
            col++;
            row--;
        }
        
        
        row = i;
        col = j;
        
        while(row < b.length && col >= 0){
            if(b[row][col] == 'Q')
                return false;
            
            col--;
            row++;
        }
        
        
        
        
        
        
        return true;
    }
}