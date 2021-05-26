class Solution {
    public int findUnsortedSubarray(int[] nums) {
        Stack<Integer> stk = new Stack<Integer>();
        int l =  nums.length+1;
        int r  = -1;
        int i= 0;
        for( i =0;i<nums.length;i++){
            while(!stk.isEmpty() && nums[stk.peek()] > nums[i])
                l = Math.min(l, stk.pop());
            
            stk.push(i);
        }
        if(l == nums.length+1)
               return 0;
            stk.clear();
        
        for( i=nums.length-1;i>=0;i--){
            while(!stk.isEmpty() && nums[stk.peek()] < nums[i])
                r = Math.max(r, stk.pop());
            
            stk.push(i);
        }
        
        return r-l+1;
    }
}