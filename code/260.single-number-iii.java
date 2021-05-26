class Solution {
    public int[] singleNumber(int[] nums) {
        int xor = 0;
        
        for(int num:nums)
            xor ^=num;
        int msk = 1;
        
        while((xor & msk) == 0)
            msk = msk<<1;
        int[] res = new int[2];
       
        for(int num: nums){
            if((num & msk) == 0)
                res[0] ^= num;
            else
                res[1] ^= num;
        }
        return res;
    }
}