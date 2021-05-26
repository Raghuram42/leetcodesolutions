class Solution {
    public int reachNumber(int target) {
//         if(target == 0)
//             return 0;
//         Queue<Integer> q = new LinkedList<Integer>();
        
//         q.offer(0);
//         int res = 0;
//         while(!q.isEmpty()){
//             int sz = q.size();
            
//             while(sz >0){
                
//                 int cur = q.poll();
//                 if(cur == target)
//                     return res-1;
                
//                 q.offer(cur-res);
//                 q.offer(cur+res);
//                 sz--;
//             }
//             res++;
//         }
//         return -1;
        
        int sum = 0;
        int sp = 0;
        target = target < 0 ? target*-1 : target;
        
        while(sum < target || (sum-target)%2 != 0)
        {
            sp++;
            sum += sp;
        }
        return sp;
    }
}