class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        
        List<List<Integer>> res = new ArrayList<>();
        
        int l = 0;
        int n = nums.length;
        
        while(l<n){
            int r = l+1;
            int e = n-1;
            
            while(r<e){
                if(nums[l]+nums[r]+nums[e] == 0){
                    res.add(Arrays.asList(nums[l], nums[r], nums[e]));
                    int curr = nums[r];
                    while(r< n && curr == nums[r])
                        r++;
                    
                    curr = nums[e];
                    
                    while(e > r && curr == nums[e])
                        e--;
                }
                else if(nums[l]+nums[r]+nums[e] < 0){
                      int curr = nums[r];
                    while(r < n && curr == nums[r])
                        r++;
                }
                else {
                    
                    int curr = nums[e];
                    
                    while(e > r && curr == nums[e])
                        e--;
                    // e--;
                }
            }
               int curr = nums[l];
                    while(l< n && curr == nums[l])
                        l++;
        }
        
        return res;
    }
}