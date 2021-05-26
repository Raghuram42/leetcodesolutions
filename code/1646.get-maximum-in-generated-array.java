class Solution {
    public int getMaximumGenerated(int n) {
        if(n>=1 && n<=2)
            return 1;
        if(n == 0)
            return 0;   
        int[] nums = new int[n+1];
        nums[0] = 0;
        nums[1] = 1;
        nums[2] = 1;
        int max = 0;
        for(int i=3;i<=n;i++){
            
            nums[i] = i%2 == 0 ? nums[i/2] : nums[i/2]+nums[(i/2)+1];
           max = Math.max(max, nums[i]);
            // System.out.println(i+" "+(i%2 == 0 ? i/2 : i/2 +" "+ ((i/2)+1))+" "+nums[i]);
        }
        
        // System.out.println(nums[n]+" sd "+ (n/2)+" " +(nums[n/2]+" "+nums[(n/2)+1]));
        return max;
    }
}