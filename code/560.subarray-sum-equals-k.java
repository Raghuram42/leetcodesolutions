class Solution {
    public int subarraySum(int[] nums, int k) {
        int c = 0;
        int res = 0;
        for(int i=0;i<nums.length;i++){
            c +=nums[i];
            if(c == k)
                res++;
            
            for(int j = i+1;j<nums.length;j++){
                c += nums[j];
                if(c == k){
                    res++;
                }
        }
            c = 0;
        }
        return res;
    }
}