class Solution {
    int dp[];
    public boolean canJump(int[] nums) {
        dp = new int[nums.length];
        if(nums.length == 1)
            return true;
      return canJumps(nums,0);
    }
    public boolean canJumps(int[] n, int i){
        
        if(dp[i] == 1)
            return false;
        dp[i] = 1;    
        if(i == n.length - 1)
            return false;
        if(n[i] == 0)
            return false;
        if( i >= n.length-1 || n[i]+i >= n.length-1)
            return true;
        int j = i+n[i]-1;
        boolean res = false;
        while(j > i){
           res = res || canJumps(n, j);
            j--;
        }
        return res || canJumps(n, i+n[i]);
    }
}