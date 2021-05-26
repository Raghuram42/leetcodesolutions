class Solution {
    public int[] decompressRLElist(int[] nums) {
        int len =0;
        
        for(int i=0;i<nums.length;i++){
            if(i%2==0)
                len+=nums[i];
        }
        
        int[] res = new int[len];
        int ind = 0;
        for(int i=1;i<nums.length;i=i+2){
            while(nums[i-1] >0){
            res[ind++] = nums[i];
                nums[i-1]--;
            }
        }
        return res;
    }
}