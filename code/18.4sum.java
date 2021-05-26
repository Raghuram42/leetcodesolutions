class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>>  res = new ArrayList<List<Integer>>();
        
        if(nums.length < 4)
            return res;
        
        Arrays.sort(nums);
        
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                int l = j+1;
                int h = nums.length-1;
                
                while(l<h){
                    if(nums[i]+nums[j]+nums[l]+nums[h] == target){
                        ArrayList<Integer> curr = new ArrayList<Integer>();
                        
                        curr.add(nums[i]);
                        curr.add(nums[j]);
                        curr.add(nums[l]);
                        curr.add(nums[h]);
                        res.add(curr);
                        
                        int l_f_val = nums[l];
                        while(l<h && nums[l] == l_f_val)
                            l++;
                            
                        int r_g_val = nums[h];
                        while(l<h && nums[h] == r_g_val)
                            h--;
                    }
                    else if(nums[i]+nums[j]+nums[l]+nums[h] < target)
                        l++;
                    else
                        h--;
                }
                while(j<nums.length-1 && nums[j] == nums[j+1])
                    j++;
            }
            
                while(i<nums.length-1 && nums[i] == nums[i+1])
                    i++;
        }
        return res;
    }
}