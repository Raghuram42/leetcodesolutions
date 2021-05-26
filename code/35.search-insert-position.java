class Solution {
    public int[] searchRange(int[] nums, int target) {
        int l = 0;
        int r = nums.length-1;
        int[] res = new int[2];
        while(l <= r){
            int mid = (l+r)/2;
            if(nums[mid] == target)
            {
                //res[0] = mid;
                int currmid = mid-1;
                while(currmid>=0 && nums[currmid] == target)
                    currmid--;
                    res[0] = currmid+1;
                currmid = mid+1;
                
                while(currmid<nums.length && nums[currmid] == target)
                    currmid++;
                    // currmid--;
                
                    res[1] = currmid-1;
                return res;
             }
            else if(nums[mid] > target){
                r = mid-1;
            }else{
                l = mid+1;
            }
        }
        
        return new int[]{-1,-1};
    }
}