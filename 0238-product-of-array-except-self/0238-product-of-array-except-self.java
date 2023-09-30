class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] left = new int[n];
        
        Arrays.fill(left, 1);
        
        for(int i=1;i<n;i++)
            left[i] = nums[i-1]*left[i-1];
        int mul = 1;
        for(int i=n-2;i>=0;i--){
            mul *= nums[i+1];
            left[i] *= mul;
        }
        
        return left;
    }
}