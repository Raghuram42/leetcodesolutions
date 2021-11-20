class Solution {
    public int singleNonDuplicate(int[] nums) {
     
        int l = 0;
        int r = nums.length-1;
        int n = nums.length;
        while(l<=r){
            int mid = (l+r)/2;
            
            if((mid-1 >=0 && nums[mid] != nums[mid-1]) && (mid+1 < n && nums[mid] != nums[mid+1]))
                return nums[mid];
            
            if(mid+1 < n){
                if(nums[mid] == nums[mid+1])
                    mid = mid+1;
            }
            
            int val = (mid-l+1);
            
            if(val%2 != 0){
                r = mid-2;
            }else
                l = mid+1;
            
        }
        
        return nums[l];
    }
}
