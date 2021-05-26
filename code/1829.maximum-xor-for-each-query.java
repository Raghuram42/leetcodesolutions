class Solution {
    public int[] getMaximumXor(int[] nums, int maximumBit) {
        int[] res = new int[nums.length];
        int xorendv = (1<<maximumBit)-1;
            // System.out.println(xorendv);
        int xor_v = nums[0];
        for(int i=1;i<nums.length;i++)
            xor_v = xor_v^nums[i];
        
        
        int i=nums.length-1;
        int p = 0;
        while(i>=0){
            res[p++] = (xor_v^xorendv);
            
            xor_v = xor_v^nums[i];
            i--;
        }
        
        return res;
    }
}