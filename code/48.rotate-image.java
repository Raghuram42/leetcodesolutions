class Solution {
    public List<List<Integer>> permute(int[] nums) {
     List<List<Integer>> res = new ArrayList<List<Integer>>();
        HashSet<Integer> vis = new HashSet<Integer>();
        
        solve(res, vis, nums, new ArrayList<Integer>());
        return res;
        
    }
    
    public void solve(List<List<Integer>> res, HashSet<Integer> vis, int[] nums, List<Integer> r){
        if(r.size() == nums.length){
            res.add(new ArrayList<>(r));
            return;
        }
        
        for(int i=0;i<nums.length;i++){
            if(!vis.contains(i)){
            r.add(nums[i]);
            vis.add(i);
            solve(res, vis, nums, r);
            r.remove(r.size()-1);
            vis.remove(i);
            }
        }
    }
}