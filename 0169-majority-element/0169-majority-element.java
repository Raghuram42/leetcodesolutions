class Solution {
    public int majorityElement(int[] nums) {
        int num = -1;
        int c = 0;
        
        int i = 0;
        int n = nums.length;
        
        while(i<n){
            if(c == 0){
                c = 1;
                num = nums[i];
            }else if(num == nums[i]){
                c++;
            }else 
                c--;
            i++;
        }
        
        return num;
    }
}