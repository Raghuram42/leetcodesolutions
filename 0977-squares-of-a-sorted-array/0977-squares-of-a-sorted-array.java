class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        
        int st = 0;
        int i = 0;
        while(i<n && nums[i] < 0)
            i++;
        
        int j = i-1;
        while(st<n){
            if(i < n && j >= 0){
                if(nums[i]*nums[i] <= nums[j]*nums[j])
                    res[st++] = nums[i]*nums[i++];
                else
                    res[st++] = nums[j]*nums[j--];
            }else if(j >=0)
                res[st++] = nums[j]*nums[j--];
            else
                res[st++] = nums[i]*nums[i++];
        }
        
        return res;
    }
}