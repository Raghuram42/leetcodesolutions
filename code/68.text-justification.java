class Solution {
    List<String> res;
    public List<String> generateParenthesis(int n) {
        res = new ArrayList<>();
        
        solve(n,n, new StringBuilder());
        
        return res;
    }
    
    public void solve(int l, int r, StringBuilder ans){
        if(l ==0 &&  r==0){
            res.add(ans.toString());
            return;
        }
        
        
        if(l > 0){
            ans.append('(');
            solve(l-1, r, ans);
            ans.deleteCharAt(ans.length()-1);
        }
        
        if(ans.length() > 0 && l<r && r>0){
         ans.append(')');
            solve(l, r-1, ans);
            ans.deleteCharAt(ans.length()-1);   
        }
    }
}