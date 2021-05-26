class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int totalsum = 0;
        
        for(int p:cardPoints)
            totalsum += p;
        int i=0;
        int currsum = 0;
        int n = cardPoints.length-k;
        for(i=0;i<n;i++)
            currsum += cardPoints[i];
        
        int res = totalsum-currsum;
        while(i<cardPoints.length)
        {
            currsum -= cardPoints[i-(n)];
            currsum += cardPoints[i];
            res= Math.max(res, totalsum-currsum);
            i++;
        }
            return res;
    }
}