class Solution {
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        
        int[][] bind = new int[efficiency.length][2];
        
        for(int i=0;i<efficiency.length;i++)
            bind[i] = new int[]{efficiency[i], speed[i]};
        
        
        Arrays.sort(bind, new Comparator<int[]>(){
            @Override
            public int compare(int[] a ,int[] b){
                return b[0]-a[0];
                
            }
        });
        
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        long totalans = 0;
        long ans = Long.MIN_VALUE;
        for(int i=0;i<efficiency.length;i++){
            if(pq.size() == k) totalans -= pq.poll();
            pq.offer(bind[i][1]);
            totalans += bind[i][1];
            ans = Math.max(ans, (totalans*bind[i][0]));
        }
        
        return mod(ans);
    }
    public int mod(long v){
        return (int)(v%1000000007);
    }
}
/*
// n = 6, speed = [2,10,3,1,5,8], efficiency = [5,4,3,9,7,2], k = 2

        1  9 - 8
        2  5 - 3
        3  3   0
        5  7 - 2
        8  2 - 6
        10 4 - 6
    
            
             6, speed = [2,10,3,1,5,8], efficiency = [5,4,3,9,7,2], k = 4
            
            ef sp
            9  1 -----e1 ->42
            7  5 -----> 35
            5  2 ------> 
            4  10 ------> 60
            3  3  
            2  8  
            
            */