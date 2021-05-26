class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        int n = nums.length+1;
        int i=0;
        List<Integer> res = new ArrayList<Integer>();
        while(i < n-1){
            if(nums[i] == n || nums[i] == i+1){
                i++;
            }
            else if(nums[i] == nums[nums[i]-1]){
                    res.add(nums[i]);
                    nums[i] = n;
                    i++;
                }
            else{
              //  System.out.println(i+" out "+nums[i]);
                int tmp = nums[i];
                nums[i] = nums[tmp-1];
                nums[tmp-1] = tmp;
               // System.out.println(i+" "+nums[i]+" inside "+nums[nums[i]-1]+" "+tmp);
            }    
         
        }
        return res;
    }
}