class Solution {
    HashMap<Integer, HashSet<Integer>> hsm;
    int[] vis;
    int[] Glvis;
    public int minJumps(int[] arr) {
        hsm = new HashMap<>();
        vis = new int[arr.length];
        Glvis = new int[arr.length];
        for(int i=0;i<arr.length;i++){
            if(!hsm.containsKey(arr[i]))
                hsm.put(arr[i], new HashSet<Integer>());
            hsm.get(arr[i]).add(i);
        }
        // int min = solve(arr, 0);
        
        Queue<Integer> q = new LinkedList<Integer>();
        q.offer(0);
        
        int ans = 0;
        while(!q.isEmpty()){
            
            int sz = q.size();
            // System.out.println(sz+" "+q);
            while(sz>0){
                int ind = q.poll();
                
                if(ind == arr.length-1)
                    return ans;
                
                
                if(ind-1>0 && vis[ind-1] != 1)
                    q.offer(ind-1);
                
                if(ind+1<arr.length && vis[ind+1] != 1)
                    q.offer(ind+1);
                
                if(hsm.containsKey(arr[ind])){
                for(int id: hsm.get(arr[ind])){
                    if(vis[id] != 1)
                        q.offer(id);
                }
                
                
                hsm.remove(arr[ind]);
                }
                vis[ind] = 1;
                sz--;
            }
            ans++;
        }
        
        
        return -1;
        
    }
}
