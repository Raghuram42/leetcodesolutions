class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        int[] out = new int[numCourses];
        for(int[] pre: prerequisites){
            if(!map.containsKey(pre[1]))
                map.put(pre[1], new ArrayList<>());
            out[pre[0]]++;
            map.get(pre[1]).add(pre[0]);
        }
        
        Queue<Integer> q = new LinkedList<>();
        
        for(int i=0;i<numCourses;i++){
            if(out[i] == 0)
                q.add(i);
        }
        
        
        if(q.isEmpty())
            return false;
        
        // System.out.println(Arrays.toString(out)+" "+map);
        while(!q.isEmpty()){
            int sz = q.size();
            
            while(sz>0){
            int curr = q.poll();
            
            for(int next: map.getOrDefault(curr, new ArrayList<Integer>())){
                out[next]--;
                if(out[next] == 0)
                    q.add(next);
            }
                sz--;
                
            numCourses--;
            }
        }
        // System.out.println(numCourses);
        return numCourses == 0;
    }
}