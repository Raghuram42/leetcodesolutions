class Solution {
    HashSet<Integer> hst;
    HashMap<Integer, ArrayList<Integer>> hsm;
    int vis[];
    int ind;
    public int[] findOrder(int numCourses, int[][] prerequisites) {
         hsm= new HashMap<Integer, ArrayList<Integer>>();
        for(int i=0;i<numCourses;i++)
            hsm.put(i, new ArrayList<Integer>());
        for(int[] pre: prerequisites){
            hsm.get(pre[0]).add(pre[1]);
        }
        vis = new int[numCourses];
        int[] res = new int[numCourses];
        hst = new HashSet<Integer>();
        ind = 0;
        for(int i=0;i<numCourses;i++){
              if(dfs(i, res))
                  return new int[0];
        }
        return res;
    }
    
    public boolean dfs(int i, int[] res){
        if(vis[i] == 1)
            return true;
        if(!hst.contains(i)){
         if(hsm.containsKey(i)){
             vis[i] = 1;
                ArrayList<Integer> temp = hsm.get(i);
                for(Integer k: temp)
                    if(dfs(k, res))
                        return true;
         }
                hst.add(i);
                res[ind] = i;
            vis[i] = 2;
                ind++;
        }
        return false;
    }
}