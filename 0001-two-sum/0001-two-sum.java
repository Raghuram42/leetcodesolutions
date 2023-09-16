class Solution {
    public int[] twoSum(int[] numscpy, int target) {
        int n = numscpy.length;
        int[][] nums = new int[n][2];
         
        for(int i=0;i<n;i++)
            nums[i] = new int[]{numscpy[i], i};
        Arrays.sort(nums, (a, b)->a[0]-b[0]);
        
        int i = 0;
        n -=1;
        
        while(i<n){
            if(nums[i][0]+nums[n][0] == target)
                return new int[]{nums[i][1], nums[n][1]};
            else if(nums[i][0]+nums[n][0] > target)
                n--;
            else
                i++;
        }
        
        return new int[0];
    }
}