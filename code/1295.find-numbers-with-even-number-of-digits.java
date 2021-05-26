class Solution {
    public int findNumbers(int[] nums) {
        int c=0;
        
        for(int n : nums){
            if(Integer.toString(n).length()%2 == 0)
                c++;
        }
        return c;
    }
}