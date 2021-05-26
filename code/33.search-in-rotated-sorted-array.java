class Solution {
    public int search(int[] nums, int target) {
        if(nums.length == 0)
            return -1;
        if(nums.length == 1)
            return nums[0] == target ? 0 : -1;
        // if(nums.length == 2)
        //     return nums[0] == target ? 0 : nums[1] == target ? 1 : -1;;
        int l =0;
        int r = nums.length-1;
        while(l<=r){
          if(nums[l]<=nums[r])
              break;
          r--;  
        }
       System.out.println(l + " "+ r);  
        if(target >= nums[l] && target <= nums[r])
            return binarysearch(l, r ,nums ,target);
    return binarysearch(r+1, nums.length-1, nums, target);
    }
    public int binarysearch(int l,int r, int[] nums, int target){
        if(l == r && nums[l] == target)
            return l;
       System.out.println(l + " "+ r);
        if(l <= r){
            int mid = l + (r-l)/2;
         if(nums[mid] < target)   
             return binarysearch(mid+1, r,nums, target);
         else if(nums[mid] == target){
             return mid;
         }   
            else{
             return binarysearch(l, mid-1, nums, target);
            }
        }
          return -1;
    }
}