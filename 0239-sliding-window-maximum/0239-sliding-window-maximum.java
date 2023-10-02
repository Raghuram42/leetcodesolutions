class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> q = new LinkedList<>();
        
        int i = 0;
        int n = nums.length;
        
        while(i<k){
            if(q.isEmpty() || nums[i] <= nums[q.peekLast()])
                q.addLast(i);
            else{
                
                while(!q.isEmpty() && nums[i] > nums[q.peekLast()])
                    q.pollLast();
                
                q.addLast(i);
            }
            i++;
        }
        
        int[] res = new int[n-k+1];
        while(i<n){
            res[i-k] = nums[q.peekFirst()];
            
            if(q.peekFirst() <= i-k)
                q.pollFirst();
            
            
            while(!q.isEmpty() && nums[i] >= nums[q.peekLast()])
                q.pollLast();
            
            q.addLast(i);
            i++;
        }
        
        res[i-k] = nums[q.peekFirst()];
        
        return res;
    }
}