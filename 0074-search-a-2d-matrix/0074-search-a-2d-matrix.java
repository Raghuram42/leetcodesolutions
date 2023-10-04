class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int i = 0;
        int n = matrix.length;
        int m = matrix[0].length;
        int j = m-1;
        while(i<n && j >=0 ){
            
            if(matrix[i][j] == target)
                return true;
            
            if(matrix[i][j] > target)
                j--;
            else
                i++;
        }
        
        return false;
    }
}