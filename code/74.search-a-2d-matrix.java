class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 1 && matrix[0].length == 0)
            return false;
        int i = bsearch(matrix, target, matrix.length-1, 0);
       //  System.out.println("i: " +i);
        if(i <= -1 || i >= matrix.length)
            return false;
        int j = bsearch2(matrix[i], target);
          //     System.out.println(i+" j: "+j);
        if(j == -1 || j >= matrix[0].length || matrix[i][j] != target){
      //       System.out.println(matrix[i][j]+" "+i+" "+j);
            return false;
            
        }
        return true;
    }
    public int bsearch(int[][] mat, int tar, int sz, int ind){
        
        int l = 0;
        int r = sz;
        
        while(l<=r){
            int mid = (l+r)/2;
            int val = mat[mid][ind];
            if(val == tar)
                return mid;
            else if(val < tar)
                l = mid+1;
            else
                r = mid-1;
                
        }
        return l-1;
        
    }
    
    public int bsearch2(int[] mat, int tar){
        
        int l = 0;
        int r = mat.length-1;;
        
        while(l<=r){
            int mid = (l+r)/2;
            int val = mat[mid];
            if(val == tar)
                return mid;
            else if(val < tar)
                l = mid+1;
            else
                r = mid-1;
                
        }
        return l;
        
    }
}