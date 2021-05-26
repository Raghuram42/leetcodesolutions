class Solution {
    public int minimumDeviation(int[] nums) {
      PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
      
        int min = Integer.MAX_VALUE;
      for(int i=0;i<nums.length;i++)  {
          
          if(nums[i]%2 == 1)
              nums[i] = nums[i]*2;
          min = Math.min(min, nums[i]);
          pq.offer(nums[i]*-1);
      }
        int ans = Integer.MAX_VALUE;;
       while(!pq.isEmpty()){
           int nm = pq.poll()*-1;
           // System.out.println(nm+" "+min);
           ans = Math.min(ans, Math.abs(nm-min));
           
           if(nm%2== 0){
               nm = nm/2;
               min = Math.min(min, nm);
               pq.offer(nm*-1);
           }else
               break;
       } 
        
        return ans;
    }
}