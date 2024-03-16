class Solution {
    public void moveZeroes(int[] nums) {
        int st = 0;
        int n = nums.length;
        int i = 0;
        int z = 0;
        while(i<n){
            if(nums[i] != 0){
                nums[st] = nums[i]; 
                st++;
                
            }else
                z++;
            i++;
        }
        
        i = n-1;
        
        
        while(i >=0 && z >0){
            nums[i--] = 0;
            z--;
        }
        
        
    }
}