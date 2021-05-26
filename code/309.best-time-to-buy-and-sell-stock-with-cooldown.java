class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        if(n==0)
            return 0;
        int idle=0,sell=0,buy=-prices[0];
        for(int i=1;i<n;i++)
        {buy=Math.max(buy,idle-prices[i]);
         idle=Math.max(idle,sell);
        sell=buy+prices[i];}
        return Math.max(idle,sell);
    }
}