class Solution {
    public int maxProfit(int[] prices) {
        int min = 10000000;
        int ans = 0;
        for(int p : prices){
            ans = Math.max(ans, p-min);
            min = Math.min(min, p);
        }
        
        return ans;
    }
}