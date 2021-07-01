class Solution {
    List<List<Integer>> ans;
    boolean[] vis;
    public List<List<Integer>> combine(int n, int k) {
        ans = new ArrayList<List<Integer>>();
        vis = new boolean[n+1];
        solve(1, n, k, new ArrayList<Integer>());
        return ans;
    }
    
    public void solve(int st, int n, int k, List<Integer> res){
        if(k==0){
            ans.add(new ArrayList<Integer>(res));
            return;
        }
        // vis[i]
        if(n-st+1 < k)
            return;
        for(int i=st;i<=n;i++)
        {
            res.add(i);
            solve(i+1, n, k-1, res);
            res.remove(res.size()-1);
        }
        
    }
}
/*
//solve(int i, int n, int k, list<intr> res){
if(k == 0)
{
    ans.add(new list(res));
    return;
}
vis[i] = true;
for(int p=i,p<=n;p++){
    res.add(p);
    solve(p+1, k-1, res);
    res.remove(res.size()-1);
    
}
return
}
*/
