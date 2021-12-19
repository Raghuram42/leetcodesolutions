class Solution {
    public long getDescentPeriods(int[] prices) {
        int i=0;
        
        int n = prices.length;
        long ans = n;
        
        while(i<n){
            int tot = 1;    
            while(i<n && i-1 >=0 && prices[i-1]-1 == prices[i])
            {
                tot++;
                i++;
            }
           
            ans += sum(tot-1);
            i++;
        }
        
        return ans;
    }
    
    public long sum(int n){
        return (n*1l*(n+1))/2;
    }
}
