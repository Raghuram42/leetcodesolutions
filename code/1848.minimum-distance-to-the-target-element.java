class Solution {
    public char[][] rotateTheBox(char[][] box) {
        char[][] rotateBox = new char[box[0].length][box.length];
        
        
        int i = 0;
        while(i<box.length){
            int j = box[0].length-1;
            int end = box[0].length-1;
            while(j>=0 && end >= 0){
                
                if(box[i][end] == '*'){
                    end--;
                    continue;
                }
                else
                if(box[i][j] == '#'){
                    swap(box, i, j, end);
                    end--;
                }else if(box[i][j] == '*'){
                    end = j-1;
                }
                j--;
                
            }
            i++;
        }

        
        rotate(box, rotateBox);
        
        
        return rotateBox;
    }
    
    public void rotate(char[][] box, char[][] rotateBox){
        
        
        for(int i=0;i<box[0].length;i++){
            for(int j=0;j<box.length;j++){
                rotateBox[i][box.length-j-1] = box[j][i];
            }
        }
    }
    public void swap(char[][] box, int i, int j, int end){
        char tmp = box[i][j];
        box[i][j] = box[i][end];
        box[i][end] = tmp;
    }
}