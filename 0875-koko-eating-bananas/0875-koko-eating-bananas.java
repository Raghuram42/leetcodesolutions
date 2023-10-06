class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1;
        int r = Integer.MAX_VALUE;
        int ans = Integer.MAX_VALUE;
        while(l<=r){
            int mid = l+(r-l)/2;
            // System.out.println(mid+" "+l+" r "+r);
            if(has(piles, h, mid)){
                ans = mid;
                r = mid-1;
            }else{
                l = mid+1;
            }
                
        }
        
        return ans;
    }
    
    public boolean has(int[] p, int t, int k){
        int i = 0;
        int n = p.length;
        
        int sum = 0;
        while(i<n){
            sum += (p[i]%k == 0 ? p[i]/k : (p[i]/k)+1);
            i++;
        }
        // System.out.println(sum);
        return sum <= t;
    }
}