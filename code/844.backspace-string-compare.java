class Solution {
    HashSet<Integer> vis;
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        if(rooms.size() == 0)
            return false;
        vis = new HashSet<Integer>();
        
        solve(rooms, 0);
        return vis.size() == rooms.size();
    }
    
    
    public void solve(List<List<Integer>> rooms, int i){
        
        if(vis.contains(i))
            return;
        
        vis.add(i);
        for(int cr : rooms.get(i))
            solve(rooms, cr);
            
    }
}