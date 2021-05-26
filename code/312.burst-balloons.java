class Solution {
    int dp[][];
    public int maxCoins(int[] nums) {
        ArrayList<Integer> num = new ArrayList<Integer>();
        num.add(1);
        for(int n:nums)
            num.add(n);
        num.add(1);
        dp = new int[500][500];
        for(int i=0;i<dp.length;i++)
            Arrays.fill(dp[i], -1 );
      //  System.out.println(num);
      return solve(num, 1, num.size()-2);  
    }
    
    public int solve(ArrayList<Integer> num, int i, int j){
        if(i>j)
            return 0;
        int max = 0;
        
        if(dp[i][j] != -1)
            return dp[i][j];
        
        for(int k=i;k<=j;k++){
            int curr = num.get(i-1)*num.get(k)*num.get(j+1);
        
            max = Math.max(max, curr+solve(num, i, k-1)+solve(num, k+1, j));
        }
        
        return dp[i][j] = max;
    }
}