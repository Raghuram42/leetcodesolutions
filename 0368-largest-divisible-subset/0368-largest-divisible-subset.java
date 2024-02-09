class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int[] dp = new int[n];
        int[] prev = new int[n];
        int max = 0;
        int last = 0;
        Arrays.fill(prev , -1);
        
        for(int i=0;i<n;i++){
            for(int j=i-1;j>=0;j--){
                
                if(nums[i]%nums[j] == 0 && dp[j]+1 > dp[i]){
                    dp[i] = dp[j]+1;
                    prev[i] = j;
                }
            }
            
            if(max < dp[i]){
                max = dp[i];
                last = i;
            }
        }
        
        List<Integer> res = new ArrayList<>();
        
        while(last >= 0){
            res.add(nums[last]);
            last = prev[last];
        }
        
        return res;
    }
}