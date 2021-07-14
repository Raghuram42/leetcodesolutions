class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        int[][] dis = new int[position.length][2];
        
        for(int i=0;i<n;i++)
            dis[i] = new int[]{position[i], speed[i]};
        
        
        Arrays.sort(dis, (a,b)->b[0]-a[0]);
        int fleet = 0;
        double t = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            
            double curt = (target-dis[i][0]+0d)/dis[i][1];
            
            if(curt > t)
            {
                fleet++;
                t = curt;
            }
        }
        
        return fleet;
    }
}

/*target = 12, position = [10,8,0,5,3], speed = [2,4,1,1,3]

p+s*t <= target
t <= (target-p)/s
*/

