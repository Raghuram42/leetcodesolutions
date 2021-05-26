class Solution {
    public int maxProduct(int[] nums) {
       if(nums.length == 0)
           return 0;
   
        int p1 = 0;
        int p2 = 0;
        int res= nums[0];//Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            p1 = (p1 == 0 ? 1 : p1) * nums[i];
            p2 = (p2 == 0 ? 1 : p2) * nums[nums.length-1-i];
            res = Math.max(res, Math.max(p1,p2));
        }
        return res;
        
    }
}