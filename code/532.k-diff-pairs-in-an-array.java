class Solution {
    public int findPairs(int[] nums, int k) {
        if(nums.length == 0)
            return 0;
        int c = 0;
        Arrays.sort(nums);
        
        for(int i=0;i<nums.length;i++){
            int j = i+1;
            while(j<nums.length){
                if(nums[j]-nums[i] <= k){
                    if(nums[j] - nums[i] == k){
                        c++;
                        break;
                    }
                    else 
                        j++;
                }
                    else
                        break;
            }
            
                        while(i+1<nums.length && nums[i] == nums[i+1])
                            i++;
        }
        return c;
    }
}