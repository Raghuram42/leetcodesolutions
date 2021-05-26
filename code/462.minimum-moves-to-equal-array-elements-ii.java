class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];
        
        int n = nums.length-1;
        for(int i=0;i<nums.length;i++){
            if(i==0){
                left[i] = nums[i];
                right[n-i] = nums[n-i];
            }
            else{
                left[i] = left[i-1]+nums[i];
                right[n-i] = right[n-i+1]+nums[n-i];
            }
            // System.out.println(left[i]+" "+right[n-i]+" "+nums[i]+" "+nums[n-i]);
        }
        long res = Integer.MAX_VALUE;
        for(int i=0;i<=n;i++){
//             int fir = nums[i]*i;
//             int sec = nums[i]*(n-i);
            
//             if(fir < 0)
//                 fir 
            long tmpres = (i==0? 0: Math.abs(nums[i]*1l*i-left[i-1]))+(i==n? 0:  Math.abs(nums[i]*1l*(n-i)-right[i+1]));
            // System.out.println(tmpres);
            res = Math.min(res, tmpres);
        }
        
        return (int)res;
    }
}