class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> q = new ArrayDeque<>();
        
        
        int st = 0;
        int end = 0;
        int n = nums.length;
        int[] res = new int[n-k+1];
        int ind = 0;
        while(end<n){
            // System.out.println(end+" "+q+" "+q.peek()+" "+(end-k));
            if(end-st+1 <= k){
                
                while(!q.isEmpty() && nums[q.peekLast()] <= nums[end])
                    q.removeLast();
                
                q.addLast(end);
                
            }else{
                
                res[ind++] = nums[q.peekFirst()];
                while(!q.isEmpty() && q.peekFirst() <= end-k)
                    q.removeFirst();
                
                while(!q.isEmpty() && nums[q.peekLast()] <= nums[end])
                    q.removeLast();
                
                q.addLast(end);
                st++;
            }
            
            end++;      
        }
        res[ind++] = nums[q.peekFirst()];
        
        return res;
    }
}

// [1,3,1,2,0,5]
// 3


// 
// [1,3,-1]