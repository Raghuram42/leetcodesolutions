class Solution {
    char[][] b;
    String w;
    public boolean exist(char[][] board, String word) {
        int wlen = word.length();
        if(wlen == 0)
            return false;
        b= board;
        w = word;
        int n = board.length;
        int m = board[0].length;
        if(n * m < wlen)
            return false;
        boolean res = false;
        
        for(int i=0;i<n;i++)
        {
            for(int j=0; j<m;j++){
                //int[][] vis = new int[n][m]; 
                //map = vis;
            if(board[i][j] == word.charAt(0) && traverse(i,j,0)){
                    res = true;
                    break;    
        }
            }
        }
        return res;
        }
    public boolean traverse(int s, int e, int t){
        
        if(s>=0 && s< b.length && e >=0 && e< b[0].length && t<w.length()){
            
            
                if(t == w.length()-1 && w.charAt(t) == b[s][e]){
               //System.out.println(s+" "+e+" "+t+" ans  "+w.length());
               return true;
            }
            else if(w.charAt(t) != b[s][e])
              return false;
            
            char c = b[s][e];
            b[s][e] = '$';
             boolean res =  traverse(s, e-1,t+1) || traverse(s, e+1,t+1) || traverse(s+1, e,t+1) || traverse(s-1, e,t+1);
            b[s][e]=c;
            return res;
        }
    
        return false;
    }
}