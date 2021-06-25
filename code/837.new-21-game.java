class Solution {
    public double new21Game(int N, int k, int w) {
        double dp[]=new double[N+1];
        double sum=0;
        for(int i=k;i<=Math.min(w+k-1,N);i++)
        {
            dp[i]=(double)(1);
            sum=sum+dp[i];
        }
        for(int i=k-1;i>=0;i--)
        {
            if(i+w<N)
                sum=sum-dp[i+w+1];
            dp[i]=(double)(sum)/(double)(w);
            sum=sum+dp[i];
        }
        return dp[0];
    }
}