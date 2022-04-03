class Solution {
    public int triangularSum(int[] nums) {
        Queue<Integer> q = new LinkedList<>();
        
        for(int num: nums)
            q.offer(num);
        
        
        while(q.size() > 1){
            int sz = q.size()-1;
            int prev = q.poll();
            
            while(sz > 0){
                int curr = q.poll();
                q.offer((curr+prev)%10);
                prev = curr;
                sz--;
            }
        }
        
        return q.poll();
    }
}
