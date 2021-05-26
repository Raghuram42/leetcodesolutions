class Solution {
    public int maxProfit(int[] prices) {
        int min_p = 1000000;
        int max_pro  = 0;
        
        for(int i=0;i<prices.length;i++){
            if(prices[i] < min_p){
                min_p = prices[i];
            }
            else if(prices[i]-min_p > max_pro){
                max_pro = prices[i]-min_p;
            }
                
        }
        return max_pro;
    }
}