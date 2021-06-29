class Solution {
    public int longestOnes(int[] nums, int k) {
        return solve(nums, 0, nums.length-1, k);
    }

    public int solve(int[] nums, int i, int n, int k){
        int st = i;
        int end = i;
        int res = 0;
        int p = k;
        int maxconsones = 0;
         int consones = 0;
        while(end<=n){
            if(nums[end] == 0 && p<=0 && k>0){
                res = Math.max(res, end-st);
                
                while(st<=n && nums[st] == 1 && st<=end)
                    st++;
    
                if(st<=n && nums[st] == 0  && st<end){
                    st++;
                    p++;
                }
            }
            if(nums[end] == 0){
                p--;
                end++;
            }
            while(end<=n && nums[end]==1){
                end++;
                consones++;
            }
            maxconsones = Math.max(maxconsones, consones);
            consones=0;
            
        }
        // System.out.println(end+" end "+st);
        res = k>0 ? Math.max(res, end-st) : maxconsones;
        return res;
    }
}
