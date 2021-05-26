class Solution {
    int ans;
    int[] vis;
    public int countArrangement(int n) {
        ans = 0;
        vis = new int[n+1];
        solve(1, n);
        return ans;
    }
    
    public void solve(int i, int n){
        if(i == n+1){
            ans++;
            return;
        }
        
        for(int p=1;p<=n;p++){
            if(vis[p] != 1 &&(p%i==0 || i%p == 0)){
                vis[p] = 1;
                solve(i+1, n);
                vis[p]= 0;
            }
        }
        
    }
}