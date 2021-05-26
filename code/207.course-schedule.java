class Solution {
    ArrayList<ArrayList<Integer>> ed;
    int[] vis;
    boolean n;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(numCourses == 1 || prerequisites.length < 1)
            return true;
        ArrayList<ArrayList<Integer>> edg = new ArrayList<ArrayList<Integer>>();

        for(int i=0;i<numCourses;i++)
            edg.add(new ArrayList<Integer>());
        
        for(int[] a : prerequisites)
            edg.get(a[0]).add(a[1]);
        
        
        n = false;
        ed = edg;
        vis= new int[numCourses];
        
        
        for(int i=0;i<edg.size();i++){
            if(vis[i] != 1 && vis[i] != 2){
                n = false;
                travers(i);
                if(n)
                    return false;
            }
        }
        return true;
    }
    
    
    public void travers(int ii){
        vis[ii] = 1;
        ArrayList<Integer> arr = ed.get(ii);
        for(int i=0;i<arr.size();i++){
            if(n){
                return;
            }
            if(vis[arr.get(i)] == 1){
                n = true;
                return;
            }
            else if(vis[arr.get(i)] == 2)
                  continue;
            travers(arr.get(i));
            
        }
        vis[ii] = 2;
    }
}