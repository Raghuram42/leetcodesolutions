class Solution {
    public boolean canBeIncreasing(int[] nums) {
        
        for(int i=0;i<nums.length;i++){
            boolean ans = true;
            for(int j=0;j<nums.length;j++){
                int next = j+1;
                if(i == j+1)
                    next = j+2;
                 
                    
                if(i != j && j<nums.length && next < nums.length && nums[j] >= nums[next])
                {
                    ans = false;
                    break;
                }
                if(i==j+1)
                    j++;
                
            }
            
                if(ans)
                    return true;
        }
        
        
        return false;
    }
}