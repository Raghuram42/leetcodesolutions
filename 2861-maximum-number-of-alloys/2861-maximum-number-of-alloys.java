class Solution {
    public int maxNumberOfAlloys(int n, int k, int budget, List<List<Integer>> composition, List<Integer> stock, List<Integer> cost) {
     int l = 0;
     int r = Integer.MAX_VALUE;
        
        int ans = 0;
        while(l<=r){
            int mid = (int)((l+0l+r)/2);
            
            if(pos(mid, n, k, budget, composition, stock, cost)){
                ans = mid;
                l = mid+1;
            }else
                r = mid-1;
        }
        
        return (int)ans;
    }
    
    
    public boolean pos(int mid, int n, int k, int b, List<List<Integer>> c, List<Integer> s, List<Integer> co){
        long minCost = Integer.MAX_VALUE;
        
        
        for(int i=0;i<k;i++){
            long currCost = 0;
            
            for(int j=0;j<c.get(i).size();j++){
                long totalReq = c.get(i).get(j)*1l*mid;
                
                
                long extra = totalReq-s.get(j);
                if(extra > 0)
                    currCost += extra*co.get(j);
            }
            
            minCost = Math.min(minCost, currCost);
        }
        // System.out.println(mid +" mid "+minCost+" "+b);
        
        return minCost <= b;
    }
}