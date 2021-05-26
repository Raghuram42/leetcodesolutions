class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        return bsearchmatrix(matrix, target);
    }
    public boolean bsearchmatrix(int[][] m, int target){
        
       for(int i=0;i<m.length;i++){
           if(target >= m[i][0] && target <= m[i][m[0].length-1])
               if(bsearch(m[i], target))
                   return true;
       }
        return false;
    }
    
    public boolean bsearch(int[] m, int target){
        int l = 0;
        int r = m.length-1;
        // System.out.println(md);
        while(l<r){
            int mid = (l+r)/2;
            if(m[mid] == target)
                return true;
            else if(target > m[mid])
                l = mid+1;
            else
                r = mid-1;
            
        }
        return l < m.length && m[l] == target;
    }
}