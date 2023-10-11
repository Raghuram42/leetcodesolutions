class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        res = new ArrayList<List<Integer>>();
        
        s(candidates, target, 0, new ArrayList<Integer>());
        return res;
    }
    
    public void s(int[] c, int t, int i, List<Integer> temp){
        
        if(t == 0){
            res.add(new ArrayList<Integer>(temp));
            return;
        }
        
        if(i >= c.length || t < 0)
            return;
        
        // if(t-c[i] >= 0 ){
        temp.add(c[i]);
        s(c, t-c[i], i, temp);
        temp.remove(temp.size()-1);
        // }
        s(c, t, i+1, temp);
}
}