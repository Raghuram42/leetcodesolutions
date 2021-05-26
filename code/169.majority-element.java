class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> hsm = new HashMap<Integer, Integer>();
        
        for(int i =0 ;i<nums.length;i++){
                
            hsm.put(nums[i], hsm.getOrDefault(nums[i], 0)+1);
            
            if(hsm.get(nums[i]) > nums.length/2)
                return nums[i];
        }
        
        return 0;
    }
}