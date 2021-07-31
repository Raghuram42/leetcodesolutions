class Solution {
    public int findLengthOfLCIS(int[] nums) {
     int res = 0;
     int i =  0;
     int n = nums.length;
        
        while( i <  n){
            int currmax = 1;
            
            while(i+1 < n && nums[i] < nums[i+1])
            {
                i++;
                currmax++;
            }
            
            res = Math.max(res, currmax);
            
            if(currmax == 1)
                i++;
        }
        
        return res;
        
    }
}
