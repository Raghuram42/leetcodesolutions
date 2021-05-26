class Solution {
    HashMap<Integer, List<Integer>> grp;
    int res;
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        
        Queue<Integer> q = new LinkedList<Integer>();
        int[] ress = new int[n];
        grp = new HashMap<Integer, List<Integer>>();
        
        for(int i=0;i<manager.length;i++){
            if(manager[i] == -1)
                continue;
            if(!grp.containsKey(manager[i]))
                grp.put(manager[i], new ArrayList<Integer>());
            
            grp.get(manager[i]).add(i);
            }
        // res = 0;
        q.offer(headID);
        
        
        while(!q.isEmpty()){
            int sz = q.size();
            int currmax = 0;
            while(sz>0){
                int curnum = q.poll();
                if(curnum == -1){
                    sz--;
                    continue;
                }
                List<Integer> currinformrs = grp.get(curnum);
                if(currinformrs == null){
                    sz--;
                    continue;
                }
                for(int i=0;i<currinformrs.size();i++){
                    
                    ress[currinformrs.get(i)] = ress[curnum]+informTime[currinformrs.get(i)];
                    if(grp.containsKey(currinformrs.get(i))){
                    q.offer(currinformrs.get(i));   
                    }
                    
                }   
                sz--;
            }
        }
        res = 0;
        for(int i=0;i<n;i++)
            res = informTime[i] == 0 ? Math.max(res, ress[i]) : res;
        return res+informTime[headID];
        
    }
    
//     public void solve(int i, int[] info, int sum){
        
        
//     }
}