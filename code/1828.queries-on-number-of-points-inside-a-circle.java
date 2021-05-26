class Solution {
    public int[] countPoints(int[][] points, int[][] queries) {
        int[] res = new int[queries.length];
        
        int p = 0;
        for(int[] q: queries){
            int c_x = q[0];
            int c_y = q[1];
            int r = q[2];
            int ans =0;
            for(int i=0;i<points.length;i++){
                int x = points[i][0];
                int y = points[i][1];
                
                
                if((x-c_x)*(x-c_x) + (y-c_y)*(y-c_y) <= r*r)
                    ans++;
            }
            res[p++] = ans;
        }
        return res;
    }
}