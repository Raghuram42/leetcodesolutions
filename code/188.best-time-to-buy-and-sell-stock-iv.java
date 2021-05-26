class Solution {
    public int maxProfit(int k, int[] prices) {
        if(prices.length == 0 || k == 0)
            return 0;
        
        int[] dp = new int[prices.length];
        int[] prev = new int[prices.length];
        if(k >= prices.length)
            return maxprofit(prices);
        for(int i=1;i<=k;i++){
            int curr_max = -prices[0];
            for(int j =1; j<dp.length;j++){
                // for(int p=0;p<=j-1;p++)
                //     curr_max = Math.max(curr_max, prices[j]-prices[p]+dp[i-1][p]);
                dp[j] = Math.max(dp[j-1],curr_max+prices[j]);
                curr_max = Math.max(curr_max, prev[j]-prices[j]);
            }
            for(int ind=1;ind<prices.length;ind++)
                prev[ind] = dp[ind];
        }
        
        return dp[prices.length-1];
    }
   public int maxprofit(int[] prices){
       int profit = 0;
       int min = prices[0];
       
       for(int i=1;i<prices.length;i++){
           if(prices[i-1] >= prices[i])
               min = prices[i];
           else{
               profit += prices[i]-min;
               min = prices[i];
           }
       }
       return profit;
   }
}