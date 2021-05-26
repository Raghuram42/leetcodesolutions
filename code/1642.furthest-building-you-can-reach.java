class Solution {
    int res;
    public int countVowelStrings(int n) {
     int[] nums = new int[]{1,2,3,4,5};   
        res = 0;
        solve(nums, 0, n);
     return res;
    }
    
    public void solve(int[] nums, int i, int n){
        
        if(i>=nums.length)
            return;
        
        if(n == 0){
            res++;
            return;
        }
        
        for(int k=i;k<nums.length;k++)
            solve(nums, k, n-1);
        
    }
}