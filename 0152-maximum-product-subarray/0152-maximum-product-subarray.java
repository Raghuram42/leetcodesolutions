class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int[] left = new int[n];
        
        int i = 0;
        int p = 1;
        int ans = Integer.MIN_VALUE;

        while(i<n){
            p = p*nums[i];
            left[i] = p;
            ans = Math.max(ans, nums[i]);
            ans = Math.max(ans, left[i]);
            if(p == 0)
                p=1;
            i++;
        }
        
        i = n-1;
        p=1;
        while(i>=0){
                 p = p*nums[i];
            ans = Math.max(ans, p);
            
            
            if(p == 0)
                p=1;
            i--;
        }
        
        return ans;
    }
}