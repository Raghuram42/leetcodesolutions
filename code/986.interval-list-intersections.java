class Solution {
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        ArrayList<int[]> res = new ArrayList<int[]>();
        
        int l = 0;
        int r = 0;
        
        while(l < A.length && r < B.length){
            int f1 = Math.max(A[l][0], B[r][0]);
            int s1 = Math.min(A[l][1], B[r][1]);
            
            if(A[l][1] < B[r][0] || A[l][0] > B[r][1]){
                f1 = 0;
                s1 = 0;
            }
            
            if(f1 != 0 || s1 !=0)
                 res.add(new int[]{f1, s1});
            
            if(A[l][1] < B[r][1])
                l++;
                else
                    r++;
            
            
        }
        
        return res.toArray(new int[res.size()][]);
    }
}