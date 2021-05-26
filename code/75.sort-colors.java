class Solution {
    public void sortColors(int[] nums) {
        int w = 0;
        int r = 0;
        int b = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i] == 2)
                b++;
            if(nums[i] == 0)
                r++;
            if(nums[i] == 1)
                w++;
        }
        
        for(int i=0;i<nums.length;i++){
            if(r>0){
                nums[i] = 0;
                r--;
            }else if(w>0){
                nums[i] = 1;
                w--;
            }
            else{
                nums[i]=2;
                b--;
            }
        }
    }
}