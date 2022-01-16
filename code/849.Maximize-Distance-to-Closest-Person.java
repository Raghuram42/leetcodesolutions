class Solution {
    public int maxDistToClosest(int[] seats) {
        int n = seats.length;
        int[] r = new int[n+1];
        
        int i = n-1;
        r[n] = n-1;
        while(i >=0){
            if(seats[i] == 0)
                r[i] = r[i+1]+1;
            else 
                r[i] = 0;
            i--;
        }
        
        i = 0;
        int ans = 0;
        int p = 0;
        while(i<n){
            if(seats[i] == 1)
                p = 0;
            else
                p++;
            
            ans = Math.max(ans, Math.min(r[i], p));
            if(i==0)
                ans = r[i];
            
            i++;
        }
        return ans;
    }
}
