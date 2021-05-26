class Solution {
   public int removeDuplicates(int[] nums) {
    if(nums==null){
        return 0;
    }
    if(nums.length<3){
        return nums.length;
    }
 
    int i=0;
    int j=1;
/*
 
         i, j    1 1 1 2 2 3
step1    0  1      i j
step2    1  2      i   j
step3    1  3        i   j
step4    2  4          i   j
 
*/
    while(j<nums.length){
        if(nums[j]==nums[i]){
            if(i==0){
                i++;
                j++;
            }else if(nums[i]==nums[i-1]){
                j++;
            }else{    
                i++;
                nums[i]=nums[j];
                j++;
            }
        }else{
            i++;
            nums[i]=nums[j];
            j++;
        }
    }
 
    return i+1;
}
}