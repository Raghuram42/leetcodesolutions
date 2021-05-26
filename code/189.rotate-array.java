
class Solution {
    public void rotate(int[] nums, int k) {
        if( k==1 && nums.length == 1 || k== nums.length || k==0)
            return;
        
        if(k > nums.length)
            k = k%nums.length;
     
    
        for(int i=0;i<nums.length/2;i++){
            int t = nums[i];
            nums[i] = nums[nums.length-i-1];
            nums[nums.length-i-1] = t;
        }
        
        
        for(int i=0;i<k/2;i++){
            int t = nums[i];
            nums[i] = nums[k-i-1];
            nums[k-i-1] = t;
        }
        int  j = nums.length-1;
       // System.out.println(k);
        for(int i=k;i<=j;i++){
         //   System.out.println(k);
            int t = nums[i];
            nums[i] = nums[j];
            nums[j] = t;
            j--;
        }
        
        
    }
}