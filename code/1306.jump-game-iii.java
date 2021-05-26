class Solution {
    int[] vis;
    public boolean canReach(int[] arr, int start) {
        vis = new int[arr.length];
        return solve(arr, start);
    }
    
    public boolean solve(int[] arr, int start){
        if(start < 0 || start >= arr.length || vis[start] == 1)
            return false;
        
        if(arr[start] == 0)
            return true;
        
        int j1 = start + arr[start];
        int j2 = start - arr[start];
        
        
        vis[start] = 1;
        return  solve(arr, j1) || solve(arr, j2);
    }
}