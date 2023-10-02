class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        
        int[][] b = new int[n][2];
        int i = 0;
        
        while(i<n)
            b[i] = new int[]{position[i], speed[i++]};
        
        Arrays.sort(b, (x,y)->y[0]-x[0]);
        
        int ans = 0;
        i = 0;
        double t = Integer.MIN_VALUE;
        while(i<n){
            double d = (0d+target-b[i][0])/b[i][1];
            if(d > t){
                ans++;
                t = d;
            }
            
            i++;
        }
        
        return ans;
    }
}