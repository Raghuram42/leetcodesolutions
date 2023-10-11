class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> permute(int[] nums) {
        res = new ArrayList<List<Integer>>();
        
        s(nums, new boolean[nums.length], new ArrayList<Integer>());
        return res;
    }
    
    public void s(int[] nums, boolean[] vis, List<Integer> temp){
        
        for(int i=0;i<nums.length;i++){
            if(!vis[i]){
                vis[i] = true;
                temp.add(nums[i]);
                s(nums, vis, temp);
                
                temp.remove(temp.size()-1);
                vis[i] = false;
            }
        }
        
        if(temp.size() == nums.length)
        res.add(new ArrayList<Integer>(temp));
    }
}