class LockingTree {
    int[] nodeMap;
    int[] parent;
    HashMap<Integer, List<Integer>> graph;
    public LockingTree(int[] parent) {
        int n = parent.length;
        nodeMap = new int[n];
        Arrays.fill(nodeMap, -1);
        graph = new HashMap<Integer, List<Integer>>();
        this.parent = parent;
        
        for(int i=0;i<n;i++){
            if(!graph.containsKey(parent[i]))
                graph.put(parent[i], new ArrayList<Integer>());
            
            graph.get(parent[i]).add(i);
        }
    }
    
    public boolean lock(int num, int user) {
        if(isLocked(num))
            return false;
        
        
        
        nodeMap[num] = user;
        return true;
    }
    
    public boolean unlock(int num, int user) {
        if(isLocked(num) && nodeMap[num] == user)
        {
            
            nodeMap[num] = -1;
            return true;
        }
        
        return false;
    }
    
    public boolean upgrade(int num, int user) {
        
        if(!isLocked(num) && hasNoAncestorLocked(parent[num]) && hasOneDecesandantLocked(num)){
            lock(num, user);
            return true;
        }
        
        
        return false;
    }
    
    public boolean hasNoAncestorLocked(int num){
        
        while(num != -1){
            if(nodeMap[num] != -1)
                return false;
            
            num = parent[num];
            
        }
        
        return true;
    }
    
    public boolean hasOneDecesandantLocked(int num){
        boolean res = false;
        
        Queue<Integer> q = new LinkedList<>();
        
        for(Integer next : graph.getOrDefault(num, new ArrayList<Integer>()))
            q.offer(next);
        
        while(!q.isEmpty()){
            int next = q.poll();
            
            if(nodeMap[next] != -1)
            {
                nodeMap[next] = -1;
                res = true;
            }
            
            
            for(Integer child : graph.getOrDefault(next, new ArrayList<Integer>()))
            {
                q.offer(child);
            }
            
            
        }
        
        return res;
    }
    public boolean isLocked(int num){
        return nodeMap[num] != -1;
    }
    

}

/**
 * Your LockingTree object will be instantiated and called as such:
 * LockingTree obj = new LockingTree(parent);
 * boolean param_1 = obj.lock(num,user);
 * boolean param_2 = obj.unlock(num,user);
 * boolean param_3 = obj.upgrade(num,user);
 */
