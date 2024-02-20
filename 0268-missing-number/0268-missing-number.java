class Solution {
    public int missingNumber(int[] nums) {
        int i = 0;
        int n = nums.length;
        int p = -1;
        while(i<n){
            if(nums[i] == n){
                p = n;
                i++;
            }
            else if(nums[i] != i){
                int t = nums[i];
                nums[i] = nums[t];
                nums[t] = t;
            }else
                i++;
        }
        
        if(p == -1)
            return n;
        i = 0;
        while(i<n && nums[i] == i)
            i++;
        return i;
    }
}