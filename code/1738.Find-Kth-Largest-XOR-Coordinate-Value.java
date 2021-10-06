class Solution {
    public int kthLargestValue(int[][] matrix, int k) {
        int n = matrix.length;
        int m = matrix[0].length;
        int i;
        for(i=0;i<n;i++){
            for(int j=1;j<m;j++)
                matrix[i][j] = matrix[i][j]^matrix[i][j-1];
        }
        
        
        
        for(i=1;i<n;i++){
            for(int j=0;j<m;j++)
                matrix[i][j] = matrix[i][j]^matrix[i-1][j];
        }
        
        
        List<Integer> allv = new ArrayList<>();
        
        
        for(i=0;i<n;i++){
            for(int j=0;j<m;j++)
                allv.add(matrix[i][j]);
        }
        
        Collections.sort(allv);
        
        return allv.get(allv.size()-k);
    }
}
