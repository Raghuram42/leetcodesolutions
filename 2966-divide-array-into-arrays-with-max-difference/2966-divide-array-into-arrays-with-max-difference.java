class Solution {
    public int[][] divideArray(int[] nums, int k) {
        List<int[]> res = new ArrayList<>();
        Arrays.sort(nums);
         for(int i=0;i<nums.length;){
             if(i+2 >= nums.length)
                 return new int[0][0];
             if(nums[i+2]-nums[i] <= k)
                 res.add(new int[]{nums[i], nums[i+1], nums[i+2]});
             else 
                 return new int[0][0];

                 
             i+=3;
         }
        int[][] ans = new int[res.size()][3];
        
        for(int i=0;i<res.size();i++)
            ans[i] = res.get(i);
    
        return ans;
    }
}