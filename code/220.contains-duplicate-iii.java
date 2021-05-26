class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        
        if(nums == null || nums.length == 0)
            return false;
        
        TreeSet<Integer> ts = new TreeSet<Integer>(); 
        
        for(int i=0;i<nums.length;i++){
            
            Integer L_near = ts.floor(nums[i]);
            if(L_near != null && nums[i] <= L_near+t){
                return true;
            }
            Integer R_near = ts.ceiling(nums[i]);
            if(R_near != null && nums[i] >= R_near-t){
                return true;
            }
            
            ts.add(nums[i]);
            
            if(i >= k)
                ts.remove(nums[i-k]);
        }
        
        
        
        return false;
    }
}