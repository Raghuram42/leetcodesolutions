class Solution {
    public boolean canSortArray(int[] nums) {
        if(alreadySorted(nums))
            return true;
        int i = 0;
        int n = nums.length;
        int max = 0;
        int min = Integer.MAX_VALUE;
        for( i=0;i<nums.length;){
            int num = nums[i];
            int bits = getB(num);
            // if(map[bits] == 1 )
            //     return false;
            int prevmax = max;
            int prevmin = min;

            max = 0;
            min = Integer.MAX_VALUE;
            while(i< n && getB(nums[i]) == bits){
                max = Math.max(max, nums[i]);
                min = Math.min(min, nums[i]);
                i++;
            }
            // System.out.
            // System.out.println(i+" "+bits+" "+prevmax+" "+min);

            if(prevmax > min )
                return false;
            
            // map[bits] = 1;
        }
        
        
        return true;
    }
    public int getB(int n){
        int ans = 0;
        int p = n;
        while(n>0){
            ans += (n&1);
            n = n >> 1;
        }
                // System.out.println(p+" "+ans);

        return ans;
    }
    public boolean alreadySorted(int[] nums){
        int i = 1;
        int n = nums.length;
        // System.out.println(Arrays.toString(nums));
        while(i<n && nums[i-1] <= nums[i])
            i++;
        
        return i == n;
            
    }
}

/*
3   00011 - 2 -> 0
16  10000 - 1 -> 1
8   01000   1 -> 2
4   00100   1 -> 3
2   00010   1 -> 4

2 -> 0
1 -> 4 3 2 1


*/