class Solution {
    public int numEnclaves(int[][] A) {
        int noofons = 0;
    
        for(int i=0;i<A.length;i++){
        for(int j=0;j<A[0].length;j++){
                if(A[i][j] == 1 && (i==0 || j == 0 || i == A.length-1 || j== A[0].length-1))
                  solve(A, i, j);
            }
        }
        
        
        
        for(int i=0;i<A.length;i++){
        for(int j=0;j<A[0].length;j++){
            if(A[i][j] == 1)
                    noofons++;
            }
        }

        return noofons;
        
        
    }
    
    public void solve(int[][] A, int i, int j){
        if(i<0 ||  j<0 || i >= A.length || j >= A[0].length)
            return;
        
        if(A[i][j] == 0)
            return;
        
        A[i][j] = 0;
        
        solve(A, i-1, j);
        solve(A, i+1, j);
        solve(A, i, j-1);
        solve(A, i, j+1);
        
        
        
    }
}