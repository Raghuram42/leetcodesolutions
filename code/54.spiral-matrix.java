class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int top = 0;
        int bottom = matrix.length-1;
        
        int left = 0;
        int right = matrix[0].length-1;
        List<Integer> res = new ArrayList<>();
        
        int dir = 1;
        while(left <= right && top <= bottom){
            
            if(dir == 1){
                
                for(int d=left;d<=right;d++)
                    res.add(matrix[top][d]);
                
                top++;
                dir++;
            }
            
            else if(dir == 2){
                for(int i=top;i<=bottom;i++)
                    res.add(matrix[i][right]);
                
                right--;
                dir++;
            }
            
            else if(dir == 3){
                
                for(int i=right;i>=left;i--)
                    res.add(matrix[bottom][i]);
                
                bottom--;
                dir++;
            }
            
            else if(dir == 4){
                
                for(int i=bottom;i>=top;i--)
                    res.add(matrix[i][left]);
                
                left++;
             dir = 1;   
            }
            
            
        }
        return res;
    }
}