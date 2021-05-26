class Solution {
    int[][][] dp;
    public int wiggleMaxLength(int[] nums) {
        dp = new int[nums.length][nums.length][2];
        // for(int  i=0;i<nums.length;i++){
        //     Arrays.fill(dp[i][0] , -1);
        //     Arrays.fill(dp[i][1] , -1);
        // }
        int p= 1;
        int k=1;
        for(int i=1;i<nums.length;i++){
            if(nums[i-1] < nums[i])
                p = k+1;
            if(nums[i-1] > nums[i])
                k=p+1;
        }
        return Math.max(p,k);
        // return Math.max(solve(nums, 0, 1, 1), solve(nums, 0, 1, 0))+1;
    }
    public int solve(int[] nums, int i, int j, int pos){
        if(i>=nums.length || j>=nums.length)
            return 0;
        int res =0 ;
        
        if(dp[i][j][pos] != 0){
            // System.out.println(dp[i][j][pos]+" "+i+" "+j+" "+pos);
            return dp[i][j][pos];
        }
        if(pos == 1){
            if(nums[j] > nums[i])
                res = 1+solve(nums, i+1,j+1, 0);
            else
                res = solve(nums, i,j+1, pos);
        }else{
            if(nums[i] > nums[j])
                res = 1+solve(nums, i+1,j+1, 1);
            else
                res = solve(nums, i,j+1, pos);
        }
        res = Math.max(res, solve(nums, i+1, j+1, pos));
        return dp[i][j][pos] = res;
        
    }
}