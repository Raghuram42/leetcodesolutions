class Solution {
    public void nextPermutation(int[] nums) {
        if(nums.length == 0 || nums == null )
            return;
        int i = nums.length-2;
        while(i>=0 && nums[i]>=nums[i+1])
            i--;
        
        if(i>=0){
            
            int j = nums.length-1;
            while(nums[j] <= nums[i])
                j--;
            
            swap(nums, i, j);
        }
        
        rev(nums, i+1, nums.length-1);
        
    }
    
    public void swap(int A[], int i, int j){
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }
    
    
    public void rev(int A[], int i, int r){
        
        while(i<r){
            swap(A, i++, r--);
        }
    }
}