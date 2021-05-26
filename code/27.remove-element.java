class Solution {
    public int removeElement(int[] nums, int val) {
        int n_v = 0;
        
        for(int i=0;i<nums.length;i++){
            n_v += nums[i] == val ? 1: 0;
    //        System.out.println(nums[i]);
        }
        
        int las = 0;
        for(int i=0;i<nums.length-n_v;i++)
        {
            if(nums[i] == val){
                while(nums[nums.length-1+las] == val)
                las--;
                nums[i] = nums[nums.length-1+las];
                las--;
                
            }
        }
        return nums.length-n_v;

}
}