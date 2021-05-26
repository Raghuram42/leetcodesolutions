class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        
        for(int i=0;i<nums.length;i++)
           nums[i] = nums[i]-1;
        
       reorder(nums);
        
   //    reorder(nums);
        ArrayList<Integer> res = new ArrayList<Integer>();
        for(int i=0;i<nums.length;i++){
            //System.out.println(nums[i]);
            if(nums[i] != i){
                res.add(i+1);
            }
        }
        return res;
    }
    
    
    public void swap(int nums[] , int i){
        //System.out.println(nums[i]+" "+nums[nums[i]]+" "+i+"  i ");
                
                int t = nums[nums[i]];
                nums[nums[i]] = nums[i];    
                nums[i] = t;
    }
    
    public void reorder(int nums[]){
        for(int i=0;i<nums.length;i++){
              while (nums[i] != i && nums[nums[i]] != nums[i]) {
                swap(nums, i);
            }
        }
            // for(int i=0;i<nums.length;i++)
            //  System.out.println(nums[i]);
            
    }
}