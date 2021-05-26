class Solution {
    public int firstMissingPositive(int[] nums) {
       if(nums.length == 0 || nums.length == 1 && nums[0] != 1)
           return 1;
        int i = 0;
        int n = nums.length+2;
        
        for(i=0;i<nums.length;i++){
            //System.out.println(i+" out "+(nums[i]>n)+" "+n);
            if(nums[i] > nums.length || nums[i] <= 0)
                nums[i] = n;
        }
        i = 0;
        while(i<nums.length){
        //     System.out.println(i+" out "+nums[i]+" "+n);
            if(nums[i] != n && nums[i]-1 != i){
         // System.out.println(i+" in "+nums[i]+" "+n);
                int t = nums[nums[i]-1];
                if(t == nums[i]){
                    i++;
                    continue;
                }
                nums[nums[i]-1] = nums[i];
                nums[i] = t;
                continue;
            }
            i++;
        }
        int p = 1;
      for(int num:nums){
          if(num == p)
              p++;
          else 
              break;
      }
        return p;
    }
}