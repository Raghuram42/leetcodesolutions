class Solution {
    int min;
    int ans;
    public int closestCost(int[] baseCosts, int[] toppingCosts, int target) {
        ans = Integer.MIN_VALUE;
        // min = ;
        
        for(int b:baseCosts)
        solve(toppingCosts, target, b, 0);
        
        
        return ans;
    }
    
    public void solve(int[] tops, int tar, int cost, int i){
        if(i == tops.length){
            if(Math.abs(cost-tar) <= Math.abs(ans-tar)){
                if(Math.abs(cost-tar) == Math.abs(ans-tar))
                    ans = Math.min(ans, cost);
                else
                    ans = cost;
                
            }
            return;
        }
        
        
        solve(tops, tar, cost, i+1);
        solve(tops, tar, cost+tops[i], i+1);
        solve(tops, tar, cost+tops[i]+tops[i], i+1);
        
        
    }
}