class Solution {
    public int[] findErrorNums(int[] nums) {
        int i =0 ;
        while(i<nums.length){
            while(i+1 != nums[i]){
                if(nums[i] == nums[nums[i]-1])
                    break;
                int t = nums[nums[i]-1];
                nums[nums[i]-1] = nums[i];
                nums[i] = t;
            }
            i++;
        }
        
        i = 0;
        while(i<nums.length){
            if(i+1 != nums[i])
                return new int[]{nums[i], i+1};
            i++;
        }
        return new int[]{-1,-1};
    }
}