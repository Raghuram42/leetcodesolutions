class Solution {
    public int maximalRectangle(char[][] matrix) {
        if(matrix.length == 0)
            return 0;
        int[][] intMat = new int[matrix.length][matrix[0].length];
        
        for(int i=0;i<matrix[0].length;i++){
            for(int j=0;j<matrix.length;j++){
                if(j == 0)
                intMat[j][i] = matrix[j][i]-'0';
                else if(matrix[j][i] != '0'){
                    intMat[j][i] = matrix[j][i]-'0' + intMat[j-1][i];
                }
            }
          
        }
        int area = 0;
        for(int i=0;i<intMat.length;i++){
            int min = 5000;
             // System.out.println(Arrays.toString(intMat[i]));
            int j = 0;
            int maxind = 0;
            Stack<Integer> stk = new Stack<>();
            while(j<intMat[i].length){
            if(stk.isEmpty()){
                stk.push(j++);
            }else if(intMat[i][stk.peek()] <= intMat[i][j]){
                stk.push(j++);
                }
            else{
                int ind = stk.pop();
                if(stk.isEmpty())
                area = Math.max(area, intMat[i][ind] * j);
                else
                    area = Math.max(area, intMat[i][ind] * (j-stk.peek()-1));
                
            }
                // j++;
            }
            
                 while(!stk.isEmpty()){
            int ind = stk.pop();
                if(stk.isEmpty())
                area = Math.max(area, intMat[i][ind] * j);
                else
                    area = Math.max(area, intMat[i][ind] * (j-stk.peek()-1));
        }
        
    }

        return area;    
        }
   }