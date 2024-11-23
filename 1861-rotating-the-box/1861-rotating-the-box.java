class Solution {
    public char[][] rotateTheBox(char[][] box) {
        int n = box.length;
        int m = box[0].length;
        
        char[][] rowToCol = new char[m][n];
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                rowToCol[j][n-i-1] = box[i][j];
            }
        }
        
        n = rowToCol.length;
        m = rowToCol[0].length;
        int i = n-1;
        int j = 0;
        System.out.println(n+" "+m);
        
        while(j < m){
            i = n-1;
            int st = i;
            
            while(i >= 0){
                  // System.out.println(i+" "+j+" "+st+"  rowToCol[i][j] "+ rowToCol[i][j]+" st "+ rowToCol[st][j]+" "+( rowToCol[i][j] == '.'));
                if(rowToCol[i][j] == '.'){
                    i--;
                }else if(rowToCol[i][j] == '#'){
                while(i>=0 && rowToCol[i][j] == '#'){
                    rowToCol[st][j] = rowToCol[i][j];
                    if(st != i)
                    rowToCol[i][j] = '.';
                    st--;
                    i--;
                }
                
                if(i>= 0 && rowToCol[i][j] == '*'){
                    i--;
                    st = i;
                }
            }else{
                    i--;
                    st = i;
                }
        }
        j++;
        }
        
        return rowToCol;
    }
}