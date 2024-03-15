class Solution {
    public boolean increasingTriplet(int[] nums) {
        Stack<Integer> stk = new Stack<>();
        
        int i = 0;
        int n = nums.length;
        int min = Integer.MAX_VALUE;
        
        stk.push(min);
        while(i<n){
            
            if(min < nums[i])
                return true;
            
            if(stk.isEmpty())
                stk.push(nums[i]);
            else{    
                while(!stk.isEmpty() && stk.peek() >= nums[i])
                    stk.pop();
                
                if(stk.size() > 0)
                    min = Math.min(min, nums[i]);
                
                stk.push(nums[i]);
            }
            i++;
        }
        
        return false;
    }
}