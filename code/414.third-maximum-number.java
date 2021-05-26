class Solution {
    public int thirdMax(int[] nums) {
     
        if(nums.length == 0)
            return 0;
        
        if(nums.length <=2)
            return nums.length == 1 ? nums[0] : Math.max(nums[0], nums[1]);
        if(nums.length == 3){
            return nums[0] == nums[1] ? Math.max(nums[2],nums[1]) : nums[2] == nums[1] ? Math.max(nums[0],nums[1]) : nums[0] == nums[2] ? Math.max(nums[2],nums[1]) :Math.min(Math.min(nums[0],nums[1]),nums[2]);
        }
        int a[] = new int[3];
        a[0] = Integer.MIN_VALUE;
        a[1] = Integer.MIN_VALUE;
        a[2] = Integer.MIN_VALUE;
        int t  = 0;
       // System.out.println(f+" "+s+" "+t);
        for(int i=0;i<nums.length;i++){
            if(nums[i] > a[t]){
                if(nums[i] > a[t+2])
                    a[t+2] = a[t+1];
                if(nums[i] > a[t+1])
                    a[t+1] = a[t];
                a[t] = nums[i];
         }
            else if(nums[i] == a[t] || nums[i] == a[t+1]){
                continue;
            }
            else {
                if(nums[i] > a[t+1]){
                    a[t+2] = a[t+1];
                    a[t+1] = nums[i];
                    
                }
                else if(nums[i] > a[t+2])
                    a[t+2] = nums[i];
            }
        }
        //System.out.println(a[0]+" "+a[1]+" "+a[2]);
        return Math.min(Math.min(a[0],a[1]),a[2]) == Integer.MIN_VALUE ? Math.max(Math.max(a[0],a[1]),a[2]) : Math.min(Math.min(a[0],a[1]),a[2]);
        
    }
}