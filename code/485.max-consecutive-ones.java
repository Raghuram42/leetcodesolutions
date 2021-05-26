class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int c_no_of_ones = 0;
        int max_no_of_ones = -1;
        for(int n : nums){
            if(n == 1)
                c_no_of_ones++;
            
            if(n == 0){
                if(max_no_of_ones < c_no_of_ones)
                       max_no_of_ones = c_no_of_ones;
                c_no_of_ones = 0;
                }
        }
        
        return max_no_of_ones < c_no_of_ones ? c_no_of_ones : max_no_of_ones;
    }
}