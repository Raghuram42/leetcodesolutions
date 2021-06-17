class Solution {
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        int st = -1;
        int end = -1;
        int res = 0;
        
        int n = nums.length; 
        for(int i=0;i<n;i++){
            if(nums[i] > right){
                st = i;
                end = i;
            }else if(nums[i] < left)
                res += end-st;
            else{
                end = i;
                res += end-st;
            }
        }
        
        return res;
    }
}