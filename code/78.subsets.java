class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
        
        helper(res, new ArrayList<Integer>(), nums, 0);
        return res;
    }
    
    public void helper(ArrayList<List<Integer>> res, ArrayList<Integer> currlist, int[] nums, int i){
        res.add(new ArrayList<Integer>(currlist));
        
        for(int p = i;p<nums.length;p++){
            currlist.add(nums[p]);
            
            helper(res, currlist, nums, p+1);
            
            currlist.remove(currlist.size()-1);
        }
    }
}