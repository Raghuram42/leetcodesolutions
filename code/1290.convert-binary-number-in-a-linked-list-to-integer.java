class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int posval = 1;
        long val = -1;
        int maxnum = -1;
        for(int num:nums)
            maxnum = Math.max(maxnum, num);
        // for(int i=1;i<=maxnum;i++){
        //     long currsum = sum(nums, i);
        //     if(currsum <= threshold)
        //     {
        //      return i;   
        //     }
        // }
        
        int l = 1;
        int r = maxnum;
        
        while(l<r){
            int mid = (l+r)/2;
            if(sum(nums, mid)<= threshold*1l)
                r = mid;
            else
                l = mid+1;
        }
        return l;
    }
    
    public long sum(int[] nums, int div){
        long ans = 0;
        
        for(int num:nums)
            ans += (num%div == 0) ? num/div : (num/div)+1;
        
        return ans;
    } 
}