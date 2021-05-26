class Solution {
        List<String> res;
    public List<String> generateParenthesis(int n) {
        
     res = new ArrayList<String>();
        
    solve(n, 0,0, "" ); 
        return res;
    }
    
    public void solve(int n, int o, int c, String cures){
        if(o == c && c==n){
           res.add(cures); 
            return;
        }
        
        
        if(o<n)
            solve(n,o+1,c, cures+"(");
        
        if(o>c)
            solve(n,o,c+1, cures+")");
    }
}