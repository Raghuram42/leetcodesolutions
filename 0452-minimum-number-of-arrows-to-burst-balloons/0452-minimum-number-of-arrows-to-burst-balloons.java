class Solution {
    public int findMinArrowShots(int[][] points) {
        int ans = 1;
        int i = 1;
        int n = points.length;
        
        Arrays.sort(points, (a,b)->a[0] == b[0] ? b[1]-a[1] : a[0]-b[0]);
        
        int[] cur = points[0];
        while(i<n){
            if(points[i][0] >= cur[0] && cur[1] >= points[i][0] ){
                cur[0] = Math.max(points[i][0], cur[0]);
                cur[1] = Math.min(points[i][1], cur[1]);
            }else{
                cur = points[i];
                ans++;
            }
            
            i++;
        }
        
        return ans;
    }
}

