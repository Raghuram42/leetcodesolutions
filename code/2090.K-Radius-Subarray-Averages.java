class Solution {
    public int[] getAverages(int[] nums, int k) {
        long sum = 0;
        int div = (k*2)+1;
        int n = nums.length;
        
        int[] res = new int[n];
        
        Arrays.fill(res, -1);
        if(k != 0 && div >= n){
            return res;
        }
        int i=0;
        for(i=0;i<div && i<n;i++)
            sum += nums[i];
        int st = 0;
        res[k] = (int)((sum)/div);
        int p = k;
        p++;
        while(i < n){
            
            
            sum -= nums[st];
            sum += nums[i];
            
            res[p++] = (int)(sum/div);
            i++;
            st++;
        }

        return res;
        
        
        
    }
}
