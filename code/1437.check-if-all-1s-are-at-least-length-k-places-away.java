class Solution {
    public boolean kLengthApart(int[] nums, int k) {
        
        int tmpk = k;
        for(int i=0;i<nums.length;i++){
            if(nums[i] == 1){
                i++;
                while(i<nums.length && nums[i] != 1){
                    i++;
                    tmpk--;
                }
                // System.out.println(i+" "+tmpk);
                if(tmpk > 0 && i < nums.length)
                    return false;
                tmpk = k;
                i--;
            }
        }
        return true;
    }
}