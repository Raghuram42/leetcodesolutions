class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
       //Arrays.sort(nums);
       int[] res = new int[nums.length];
        
        for(int i=0;i<nums.length;i++){
         res[i] = nums.length-1;
        }
        
        for(int i=0;i<nums.length;i++){
            int j = i+1;
            while(j<nums.length){
                if(nums[i] > nums[j])
                    res[j]--;
                else if(nums[i] == nums[j]){
                    res[i]--;
                res[j]--;
                }else{
                    res[i]--;
                }
                j++;
            }
        }
        
        return res;
    }
}