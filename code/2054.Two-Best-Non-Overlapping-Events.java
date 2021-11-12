class Solution {
    public int maxTwoEvents(int[][] events) {
        Arrays.sort(events, (a, b)->a[0]-b[0]);
        
        int n = events.length;
        int[] maxV = new int[n+1];
        for(int i=n-1;i>=0;i--)
            maxV[i] = Math.max(maxV[i+1], events[i][2]);
        
        
        int ans = 0;
        
        for(int i=0;i<n;i++){
            int ind = bsearch(events, events[i][1]+1);
            
            // System.out.println(i+" "+ind);
            if(ind < 0)
                ans = Math.max(ans, events[i][2]);
            else 
                ans = Math.max(ans, maxV[ind]+events[i][2]);
            
            
        }
        
        return ans;
        
    }
    
    public int bsearch(int[][] e, int tar){
        int l = 0;
        int r = e.length-1;
        
        int ans = -1;
        
        while(l<=r){
            int mid = (l+r)/2;
            
            if(tar <= e[mid][0])
            {
                ans = mid;
                r = mid-1; 
            }else
                l = mid+1;
            
            
        }
        return ans;
    }
}
