class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<int[]> q = new LinkedList<int[]>();
        
        
        int i = 0;
        int n = nums.length;
         while(i<k){
                if(q.isEmpty() || nums[i] < nums[q.peekLast()[1]])
                q.addLast(new int[]{nums[i], i});
            else{
                while(!q.isEmpty() && nums[i] >= nums[q.peekLast()[1]])
                    q.pollLast();
                q.addLast(new int[]{nums[i], i});
            }
            i++;
        }
        
        
        int[] res = new int[n-k+1];
        while(i<n){
            res[i-k] = nums[q.peekFirst()[1]];
            
            if(!q.isEmpty() && q.peekFirst()[1] <= i-k)
                q.pollFirst();
            
            
            while(!q.isEmpty() && (nums[q.peekLast()[1]] <= nums[i]))
                    q.pollLast();
                
                // if(q.isEmpty())
                    q.addLast(new int[]{nums[i], i});
          
            
            
            i++;
        }
        
        res[i-k] = nums[q.peekFirst()[1]];
        return res;
    }
}