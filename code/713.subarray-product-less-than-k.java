class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if(nums.length == 0)
            return 0;
       int prod = nums[0];
        int c =  0;
//         for(int i=0;i<nums.length;i++){
//             prod = nums[i];
//             if(nums[i] < k)
//                 c++;
            
//             for(int j=i+1;j<nums.length;j++){
//                 if(prod * nums[j] < k){
//                     prod = prod * nums[j];
//                     c++;
//                 }
//                 else
//                     break;
//             }
//         }
//         return c;
        int st = 0;
        int end = 0;
        while(st<nums.length && end < nums.length){
            if(prod < k){
             end++;
                
                if(end > st)
                    c += end-st;
                
                if(end < nums.length)
                      prod = prod * nums[end];
            
            }
            else{
                  prod = prod/nums[st];
                  st++;
            }
            
        }
        return c;
        }
    }