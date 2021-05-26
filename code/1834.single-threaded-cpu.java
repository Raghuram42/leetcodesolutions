class Solution {
    public int[] getOrder(int[][] tasks) {
    int[][] taskswithId = new int[tasks.length][3];
        
        for(int i=0;i<tasks.length;i++){
            taskswithId[i] = new int[]{tasks[i][0],tasks[i][1], i};
            // if(i == 35079 || i == 4551)
            //     System.out.println(i+" "+tasks[i][0]+" "+tasks[i][1]);
        }
        Arrays.sort(taskswithId, new Comparator<int[]>(){
            @Override
            public int compare(int[] t1, int[] t2){
                if(t1[0] == t2[0])
                    return t1[2]-t2[2];
                return t1[0]-t2[0];
            }
        });
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>(){
            @Override
            public int compare(int[] t1, int[] t2){
                if(t1[1] == t2[1])
                    return t1[2]-t2[2];
                
                return t1[1]-t2[1];
            }
        });
        int time = taskswithId[0][0];
        int i = 0;
        int idletime = 0;
        int j=0;
        int[] res = new int[tasks.length];
        while( i<taskswithId.length){
         
            while(i<taskswithId.length && time >= taskswithId[i][0]){
                pq.offer(taskswithId[i]);
                i++;
            }
         
            if(pq.isEmpty())
                time = taskswithId[i][0];
            else
         {
                int[] curr = pq.poll();
                time += curr[1];
                res[j] = curr[2];
                j++;
            }
            
               
            // time++;
            
            
        }
        
        while(!pq.isEmpty()){
            res[j++] = pq.poll()[2];
        }
        
        return res;
    }
    
}
//Storage task id in another datastructure
//sort with respect to enq time 
//have priority queue ordered by processingTime