class Solution {
    public boolean validTicTacToe(String[] board) {
        int cO= 0;
        int cX= 0;
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length();j++){
                if(board[i].charAt(j) == 'X')
                    cX++;
                else if(board[i].charAt(j) == 'O')
                    cO++;
            }
        }
        
        
        if(cX == cO || cX == cO+1){
            
            boolean f1= isWin(board, 'O');
            boolean f2= isWin(board, 'X');
            // System.out.println(f1+" "+f2+" "+cX+" "+cO);
            if(f1 && f2)
            return false;
            
            if((f1 && (cX!=cO)) || (f2 && (cX != cO+1)))
                return false;
                
                return true;
            
            
        }
        
        return false;
    }
    
    public boolean isWin(String[] board, char val){
        
        boolean isvalid = true;
        for(int i=0;i<3;i++){
            if(board[i].charAt(i) != val)
            {
                isvalid= false;
                break;
            }
        }
        
        if(isvalid)
            return isvalid;
        
         isvalid = true;
         for(int i=2;i>=0;i--){
            if(board[2-i].charAt(i) != val)
            {
                isvalid= false;
                break;
            }
        }
        
        if(isvalid)
            return isvalid;
        
        for(int i=0;i<3;i++){
            isvalid = true;
            for(int j=0;j<3;j++){
                if(board[i].charAt(j) != val)
            {
                isvalid= false;
                    // System.out.println(i+" "+j+" "+val);
                break;
            }
            }
                if(isvalid)
            return isvalid;
        }
        
        
    
        
                for(int i=0;i<3;i++){
            isvalid = true;
            for(int j=0;j<3;j++){
                if(board[j].charAt(i) != val)
            {
                isvalid= false;
                break;
            }
            }
                        
         if(isvalid)
            return isvalid;
        }
        
        
        // if(isvalid)
            return isvalid;
        
        
    }
}