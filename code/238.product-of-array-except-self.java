class Solution {
    public int[] productExceptSelf(int[] nums) {
     int prod = nums[0];
        int p = nums[0];
        int sk = 0;
        for(int i=1;i<nums.length;i++){
            if(nums[i] != 0){
              p *= nums[i];  
            }
            else{
                sk++;
            }
            prod *= nums[i];
        }
        for(int i=0;i<nums.length;i++){
         //   System.out.println((int)Math.pow(nums[i], -1));
            if(nums[i] != 0)
            nums[i] = (int)(prod * 1L * Math.pow(nums[i], -1));
            else {
                nums[i] = sk > 1 ? prod: p;
            }
        }
        return nums;
        
    }
}