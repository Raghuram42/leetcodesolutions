class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int less_sum = nums[0]+nums[1]+nums[2];
        for(int i=0;i<nums.length;i++){
            int l = i+1;
            int r = nums.length-1;
            
            while(l<r){
                
                int curr_sum = nums[i] + nums[l] + nums[r];
                
                int tmp = Math.abs(target - curr_sum);
                if(tmp == 0)
                    return target;
                if(tmp < Math.abs(target-less_sum))
                    less_sum = curr_sum;
                
                if(curr_sum < target)
                    l++;
                else
                    r--;
            }
        }
        
        return less_sum;
        
    }
}