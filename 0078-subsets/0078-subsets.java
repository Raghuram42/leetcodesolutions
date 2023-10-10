class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> subsets(int[] nums) {
        res = new ArrayList<List<Integer>>();
        // res.add(new ArrayList<Integer>());
        s(nums, 0, new ArrayList<Integer>());
        return res;
    }
    
    public void s(int[] nums, int i, List<Integer> t){
        if(i>=nums.length){
            res.add(new ArrayList<Integer>(t));
            return;
        }
        t.add(nums[i]);
        s(nums, i+1, t);
        t.remove(t.size()-1);
        s(nums, i+1,t);
    }
}