class Solution {
    public int sumOfBeauties(int[] nums) {
        int n = nums.length;
        int[][] left = new int[n][2];
        int[][] right = new int[n][2];
        left[0][0] = nums[0];
        right[n-1][0] = nums[n-1];
        for(int i=1;i<n;i++){
            left[i] = Math.max(left[i-1], nums[i]);
                
        }
        
        for(int i=n-2;i>=0;i--){
            right[i] = Math.max(right[i+1], nums[i]);
        }
        int res = 0;
        for(int i=1;i<n-1;i++){
            if(left[i-1] < nums[i] && nums[i] < right[i+1])
                res += 2;
            else if(nums[i-1] < nums[i] && nums[i] < nums[i+1])
                res += 1;
        }
        return res;
    }
}
