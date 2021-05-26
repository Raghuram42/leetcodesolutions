class Solution {
    public boolean search(int[] nums, int target) {
        if(nums.length == 0)
            return false;
        return bsearch(nums, target, 0, nums.length-1);
        
    }
    
    public boolean bsearch(int[] nums, int target, int l,int e){
        if(l<0 || e>= nums.length)
            return false;
        while(l<=e){
            int mid = (l+e)/2;
            
            if(nums[mid] == target )
                return true;
            else if(nums[l] < nums[mid]){
                if(nums[mid] > target && nums[l] <= target)
                    e = mid-1; 
                else
                    l = mid+1;
            }else if(nums[mid] < nums[e]){
                if(nums[mid] < target && nums[e] >= target)
                    l = mid+1;
                else
                    e = mid-1;
            }
            // else if()
            //     return bsearch(nums, target, l, mid-1) ||  bsearch(nums, target, mid+1, r);
            else if(nums[mid] == nums[l] && nums[mid] == nums[e])
            {
                l++;
                e--;
            }
            else if(nums[mid] == nums[l])
                l = mid+1;
            else if(nums[mid] == nums[e])
                e= mid-1;
            
        }
        return false;
    }
}