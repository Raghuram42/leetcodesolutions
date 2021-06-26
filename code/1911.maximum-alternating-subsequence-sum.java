class Solution {
    public long maxAlternatingSum(int[] nums) {
        Stack<Integer> stk = new Stack<>();
        stk.push(nums[0]);
        int i = 1;
        
        while(i<nums.length){
            
            if(stk.size() >0 && stk.size()%2 == 1){
            while(stk.size() > 0 && stk.size()%2 == 1 && stk.peek() <= nums[i])
                stk.pop();
            }else{
                while(stk.size() > 0 && stk.size()%2 == 0 && stk.peek() > nums[i])
                stk.pop();
                
            }
            
            stk.push(nums[i++]);
            
        }
        
        
        if(stk.size()%2 == 0 && stk.size() > 0)
            stk.pop();
        
        
        long res = 0;
        
        while(!stk.isEmpty()){
            if(stk.size()%2 == 0)
                res -= stk.pop();
            else
                res+=stk.pop();
            
        }
        
        return res;
        
    }
}
/*
[4,2,5,3]
[5,6,7,8]
[6,2,1,2,4,5]
[4,5,4,5]
[4,6,6,2,3]
[6,6,6,2,3]
[7,6,6,2,3]
[7,6,6,10,3]
[7,6,6,10,3,4]
[1]
[1,90]
[90,1]
*/