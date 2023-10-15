class Solution {
    HashSet<List<String>> res;
    
    public List<List<String>> solveNQueens(int n) {
        char[][] inp =  new char[n][n];
        
        for(char[] in: inp)
            Arrays.fill(in, '.');
        res = new HashSet<>();
        
                int[] rV = new int[n];
                
                int[] cV = new int[n];
                int[] dV = new int[n+n];
                int[] rdV = new int[n+n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                
                 inp[i][j] = 'Q';
        rV[i] = 1;
        cV[j] = 1;
        dV[n+(i-j)] =1;
        rdV[i+j] = 1;
                solve(n-1, inp, rV, cV, dV, rdV,  i, j);
                 inp[i][j] = '.';
            rV[i] = 0;
            cV[j] = 0;
            dV[n+(i-j)] = 0;
            rdV[i+j] = 0;

            }
    }
        return new ArrayList<List<String>>(res);
    }
    
    public void solve(int n, char[][] inp, int[] rV, int[] cV, int[] dV, int[] rdV, int i, int j){
        // System.out.println(n+" "+i +" "+j);
               int p = inp.length;
         if(n == 0)
        {
            res.add(build(inp));
            return;
        }
        if(i+1>=inp.length)
            return;
        int x  = i+1;
        // for(int x =0;x<inp.length;x++){
            for(int y=0;y<inp.length;y++){
            
            if(rV[x]==1 || cV[y] == 1 || dV[p+(x-y)] == 1 || rdV[x+y] == 1)
                continue;
            inp[x][y] = 'Q';
            rV[x] = 1;
            cV[y] = 1;
            dV[p+(x-y)] =1;
            rdV[x+y] = 1;
            solve(n-1, inp, rV, cV, dV, rdV, x, y); 
            inp[x][y] = '.';
            rV[x] = 0;
            cV[y] = 0;
            dV[p+(x-y)] = 0;
            rdV[x+y] = 0;
           }
        // }   
   
    }
    
    public List<String> build(char[][] inp){
        List<String> res = new ArrayList<>();
        
        for(char[] in: inp)
            res.add(new String(in));
        
        return res;
    }
}