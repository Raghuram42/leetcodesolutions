class Solution {
    public int[] findDiagonalOrder(int[][] matrix) {
        if(matrix.length == 0)
            return new int[0];
        int len = Math.max(matrix.length, matrix[0].length);
        ArrayList[] res = new ArrayList[len*2];
        for(int i=0;i<len*2;i++)
            res[i] = new ArrayList<Integer>();
        int p = 0;
        for(int i=0;i<matrix.length;i++){
            int k = p;
            for(int j=0;j<matrix[0].length;j++){
                if(k%2 == 0)
                    res[k++].add(0,matrix[i][j]);
                    else
                res[k++].add(matrix[i][j]);
            }
            p++;
        }
        
        int[] ress = new int[matrix.length*matrix[0].length];
        p = 0;
        for(ArrayList<Integer> ary: res){
            // for(int a: )
    // System.out.println(ary);
            // if(ary.size() == 0)
            //     break;
            for(int a: ary)
                ress[p++] = a;
        }
        return ress;
    }
}