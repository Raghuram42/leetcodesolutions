class Solution {
    public int[] mostCompetitive(int[] nums, int k) {
        Deque<Integer> stk = new ArrayDeque<Integer>();
        
        for(int i=0;i<nums.length;i++){
            if(!stk.isEmpty() && stk.peek() > nums[i]){
                while(!stk.isEmpty() && stk.peek() > nums[i] && nums.length-i > (k-stk.size()))
                    stk.pop();
                 stk.push(nums[i]);
            }else if(k-stk.size() > 0 )
                 stk.push(nums[i]);
           
        }
        
        int[] res = new int[k];
        int p = k-1;
        while(!stk.isEmpty() && p>=0)
            res[p--] = stk.pop();
        
        return res;
    }
}