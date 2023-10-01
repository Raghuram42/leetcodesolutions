class Solution {
    public int missingNumber(int[] nums) {
        int xor = 0;
        
        for(int i=0;i<=nums.length;i++)
            xor ^= i;
        
        for(int n: nums)
            xor ^= n;
        
        return xor;
    }
}