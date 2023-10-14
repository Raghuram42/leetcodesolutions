class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        res = new ArrayList<List<Integer>>();
        int n = candidates.length;
        solve(candidates, target, 0, new ArrayList<>());
        return res;
    }
    
    public void solve(int[] c, int t, int i, List<Integer> li){
       
        if(t == 0)
        {
            List<Integer> ret = new ArrayList<Integer>(li);
            List<List<Integer>> rt = new ArrayList<>();
            rt.add(ret);
            res.add(ret);
            return;
        }
        
         if(i >= c.length)
            return;        
        int n = c.length;
        for(int p=i;p<n;p++){
            
            if((p != i && c[p] == c[p-1]) || t-c[p] < 0)
                continue;
            
            li.add(c[p]);
            solve(c, t-c[p], p+1, li);
            
            li.remove(li.size()-1);
        }
        
        
    }
}