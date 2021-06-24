class Solution {
    int[][][] dp;
    public int stoneGameII(int[] piles) {
        dp = new int[piles.length+1][2][2*(piles.length+1)];
        return solve(piles, 0, 1, 1);
    }
    
    public int solve(int[] piles, int i, int aliceChance, int m){
        if(i >= piles.length )
            return 0;
        if(dp[i][aliceChance][m] != 0)
            return dp[i][aliceChance][m];
        int anores = 0;
        int elseres = 1000000;
        for(int k=1;k<(2*m)+1;k++){
            int sum = 0;
            
            for(int p=i;p<i+k && p<piles.length;p++)
                sum+= piles[p];
            
            if(aliceChance == 1){    
                anores = Math.max(solve(piles, i+k, 0, Math.max(m,k))+sum, anores);
            }else
                elseres = Math.min(elseres, solve(piles, i+k, 1, Math.max(m,k)));       
        }

        return dp[i][aliceChance][m] = aliceChance == 1 ?  anores : elseres;
        
    }
}