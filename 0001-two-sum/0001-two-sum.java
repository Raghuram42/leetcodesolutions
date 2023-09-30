class Solution {
    public int[] twoSum(int[] num, int target) {
        
        
        int r = num.length-1;
        int[][] nums = new int[r+1][2];
        for(int i=0;i<num.length;i++)
            nums[i] = new int[]{num[i], i};
        
        Arrays.sort(nums, (a,b)->a[0]-b[0]);
        int l = 0;
        
        while(l<r){
            if(nums[l][0]+nums[r][0] == target)
                return new int[]{Math.min(nums[l][1],nums[r][1]), Math.max(nums[l][1],nums[r][1])};
            else if(nums[l][0]+nums[r][0] < target)
                l++;
            else
                r--;
        }
        
        return new int[0];
    }
}