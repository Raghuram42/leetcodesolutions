class Solution {
    public int singleNonDuplicate(int[] nums) {
        return nums[singlesort(nums ,0 ,nums.length-1)];
    }
    public int singlesort(int[] nums, int l, int e){
        int mid = l + (e-l)/2;
        
        if(mid == l || mid == e)
            return mid;
        
        if(mid - 1 >= 0 &&  nums[mid] == nums[mid - 1])
        {
            if((mid - 1)%2 == 0)
                return singlesort(nums, mid+1, e);
            else 
                return singlesort(nums, l, mid - 2);
        }
        else if (mid+1 <= nums.length-1 &&  nums[mid] == nums[mid + 1]){
            if((e-mid-1)%2 == 0){
                return singlesort(nums, l, mid-1); 
            }
            else{
                return singlesort(nums, mid+2 ,e);
            }
        }
                return mid;
    } 
}