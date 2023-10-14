class Solution {
    List<List<Integer>> res;
    List<List<Integer>>[][] dp;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        res = new ArrayList<List<Integer>>();
        int n = candidates.length;
        
        dp = new List[n][target+1];
         solve(candidates, target, 0, new ArrayList<>());
        return res;
    }
    
    public List<List<Integer>> solve(int[] c, int t, int i, List<Integer> li){
       
        if(t == 0)
        {
            List<Integer> ret = new ArrayList<Integer>(li);
            List<List<Integer>> rt = new ArrayList<>();
            rt.add(ret);
            res.add(ret);
            return rt;
        }
        
         if(i >= c.length)
            return new ArrayList<>();
        
        List<List<Integer>> fres = new ArrayList<>();
        int n = c.length;
        for(int p=i;p<n;p++){
            
            if((p != i && c[p] == c[p-1]) || t-c[p] < 0)
                continue;
            
            li.add(c[p]);
            List<List<Integer>> tres = solve(c, t-c[p], p+1, li);
            
            for(List<Integer> next: tres){
            // if(next.size() > 0)
            fres.add(next);
            }
            li.remove(li.size()-1);
        }
        
        
        return dp[i][t] = fres;
        
    }
}