class Solution {
    public int[] finalPrices(int[] prices) {
     int[] res = new int[prices.length];
        
        for(int i=0;i<prices.length;i++){
            int j =i+1;
            for(j=i+1;j<prices.length;j++){
                if(prices[j] <= prices[i]){
                    res[i] = prices[i]-prices[j];
                    break;
                    }
            }
            if(j == prices.length)
                res[i] = prices[i];
        }
        
        return res;
    }
}