class Solution {
    public int removeDuplicates(int[] nums) {
        int k =  0;
        for(int i=0;i<nums.length;i++)
        {
            if(i ==0){
                nums[k++] = nums[i];
                continue;
            }
           if(nums[i]!=nums[i-1]){           
               nums[k++] = nums[i];
    //           System.out.println(nums[k]+" "+k);
               //k++;
            }
        
               
        }
        return k;
    }
}