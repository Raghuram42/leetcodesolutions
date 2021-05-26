class Solution {
    public int singleNumber(int[] nums) {
     int c =0 ;int a =0; int b =0;
        
        for(int i=0;i<nums.length;i++){
            c = (a&~b&~nums[i]) | (~a&b&nums[i]);
            b = (~a&b&~nums[i]) | (~a&~b&nums[i]);
            a = c;
        }
        return a | b;
    }
}