class Solution {
    public int findPeakElement(int[] nums) {
        if(nums.length <= 1)
            return 0;

        
        for(int i=1;i<nums.length-1;i++)
            if(nums[i] > nums[i-1] && nums[i] > nums[i+1])
                return i;
        int peakele = 0;
        if(nums[0] < nums[1])
              peakele = 1;
        if(nums[nums.length-1] > nums[nums.length-2])
            peakele = nums[nums.length-1] == Math.max(nums[nums.length-1], nums[peakele]) ? nums.length-1 : peakele;
        else
              peakele = nums[nums.length-2] == Math.max(nums[nums.length-2], nums[peakele]) ? nums.length-2 : peakele;
       return peakele;

    }
}