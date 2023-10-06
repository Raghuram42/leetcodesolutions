class Solution {
    public int findMin(int[] nums) {
        int l = 0;
        int r = nums.length-1;
        
        while(l<r){
            int mid = l + (r-l)/2;
            
            if(nums[mid] <= nums[r])
                r = mid;
            else
                l = mid+1;
        }
        
        return nums[l];
    }
}

// [3, 4, 5, 6,7,8, 1, 2]

// [1,2,3,4,5] l < mid && mid < r => move r = mid
                // l <= mid => l = mid
// [5,4,3,2,1]


// [7, 8, 1, 2, 3]

// [1,2]