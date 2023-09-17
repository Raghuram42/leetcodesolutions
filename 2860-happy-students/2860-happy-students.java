class Solution {
    public int countWays(List<Integer> nums) {
        // return 0;
        Collections.sort(nums);
        int ans = nums.get(0) != 0 ? 1: 0;
        int n = nums.size();
        for(int i=0;i<n;i++)
            if(i+1 > nums.get(i) && (i+1 == n || i+1 < nums.get(i+1)))
                ans++;
        
        return ans;
        
        
    }
}