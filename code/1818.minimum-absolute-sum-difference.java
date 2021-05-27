class Solution {
    public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        int[] diff = new int[nums1.length];
        long sum = 0l; 
        for(int i=0;i<nums1.length;i++){
            diff[i] = Math.abs(nums1[i]-nums2[i]);
            sum += diff[i];
     
        }
        
        Arrays.sort(nums1);
        
        long res = sum;
        
        for(int i=0;i<nums2.length;i++){
            long tres = (sum-diff[i]+Math.min(greatBS(nums1, nums2[i]), leastBS(nums1, nums2[i])));
            res = Math.min(res, tres);
        }
        return (int)(res%1000000007);
    }
    
    public int greatBS(int[] nums, int target ){
        int l = 0;
        
        int end =  nums.length-1;
        int ans = 0;
        while(l<=end){
            int mid = (l+end)/2;
            if(nums[mid] == target)
                return 0;
            if(nums[mid] < target)
            {
                l = mid+1;
            }else{
                ans = mid;
                end = mid-1;
            }
        }
        // System.out.println(target +" "+nums[ans]+" "+Math.abs(target-nums[ans]));
        return Math.abs(target-nums[ans]);
    }
    
    
        
    public int leastBS(int[] nums, int target ){
        int l = 0;
        
        int end =  nums.length-1;
        int ans = 0;
        while(l<=end){
            int mid = (l+end)/2;
            if(nums[mid] == target)
                return 0;
            if(nums[mid] < target)
            {
                ans = mid;
                l = mid+1;
            }else{
                
                end = mid-1;
            }
        }
              // System.out.println(target +" "+Math.abs(target-nums[ans]));
        return Math.abs(target-nums[ans]);
    }
}