class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        res = new ArrayList<List<Integer>>();
        Arrays.sort(candidates);
        
        solve(candidates, target, 0, new ArrayList<Integer>());
        
        return res;
    }
    
    
    public void solve(int[] candidates, int target, int i, List<Integer> curr){
        
        if(target == 0){
            res.add(new ArrayList<Integer>(curr));
            return;
        }
        
        if(i>= candidates.length || candidates[i] > target)
            return;
        
        curr.add(candidates[i]);
        solve(candidates, target-candidates[i], i+1, curr);
        curr.remove(curr.size()-1);
        while(i+1<candidates.length && candidates[i] == candidates[i+1])
            i++;
        solve(candidates, target, i+1, curr);
        
    }
}