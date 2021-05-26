class Solution {
    public int[][] diagonalSort(int[][] mat) {
        for(int i=0;i<mat[0].length;i++){
            int p = 0;
            int j = i;
            ArrayList<Integer> ary = new ArrayList<Integer>();
            while(p<mat.length && j <mat[0].length)
                ary.add(mat[p++][j++]);
            
            Collections.sort(ary);
            p=0;
            j=i;
            int k=0;
            while(p<mat.length && j <mat[0].length)
                mat[p++][j++] = ary.get(k++);
        }
        
        
        for(int i=0;i<mat.length;i++){
            int p = i;
            int j = 0;
            ArrayList<Integer> ary = new ArrayList<Integer>();
            while(p<mat.length && j <mat[0].length)
                ary.add(mat[p++][j++]);
            
            Collections.sort(ary);
            p=i;
            j=0;
            int k=0;
            while(p<mat.length && j <mat[0].length)
                mat[p++][j++] = ary.get(k++);
        }
        return mat;
    }
}