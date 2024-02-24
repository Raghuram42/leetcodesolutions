class Solution {
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b)->a[1]-b[1]);
        
        HashMap<Integer, List<int[]>> g = new HashMap<>();
        
        for(int[] m : meetings){
            if(!g.containsKey(m[0]))
                g.put(m[0], new ArrayList<int[]>());
            
               if(!g.containsKey(m[1]))
                g.put(m[1], new ArrayList<int[]>());
            
            g.get(m[0]).add(new int[]{m[1], m[2]});
            g.get(m[1]).add(new int[]{m[0], m[2]});
        }
        
        pq.offer(new int[]{0, 0});
        if(!g.containsKey(0))
            g.put(0, new ArrayList<int[]>());
            
            g.get(0).add(new int[]{firstPerson, 0});
        
         if(!g.containsKey(firstPerson))
            g.put(firstPerson, new ArrayList<int[]>());
            
            g.get(firstPerson).add(new int[]{0, 0});
        HashSet<Integer> vis = new HashSet<>();
        int t = 0;
        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            
            if(!vis.contains(curr[0]) && curr[1] >= t){
                vis.add(curr[0]);
                for(int[] next: g.getOrDefault(curr[0], new ArrayList<int[]>()))
                    pq.offer(new int[]{next[0], next[1]});
                
                t = Math.max(t, curr[1]);
            }
        }
        
        return new ArrayList<Integer>(vis);
    }
}