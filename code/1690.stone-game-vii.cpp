class Solution {
public:
    vector<int>prefix;
    int dp[1001][1001];
    int get(int i,int j,vector<int>& stones)
    {
        if(i>j)
            return 0;
        if(dp[i][j]!=-1)
            return dp[i][j];
        int l=prefix[j+1]-prefix[i+1]-get(i+1,j,stones);
        int r=prefix[j]-prefix[i]-get(i,j-1,stones);
        return dp[i][j]=max(l,r);
    }
    int stoneGameVII(vector<int>& stones) 
    {
        int n=stones.size();
        memset(dp,-1,sizeof(dp));
        prefix.resize(n+1,0);
        for(int i=0;i<n;i++)
            prefix[i+1]=prefix[i]+stones[i];
        return get(0,n-1,stones);
    }
};