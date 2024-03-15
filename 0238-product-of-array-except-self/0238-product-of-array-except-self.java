class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        
        
        int i = 0;
        int prev = 1;
        
        while(i<n){
            res[i] = prev;
            prev = prev*nums[i++];
        }
        
        i = n-1;
        prev = 1;
        while(i>=0){
            res[i] *= prev;
            prev = prev*nums[i--];
        }
        
        return res;
        
    }
}