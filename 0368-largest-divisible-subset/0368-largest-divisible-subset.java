class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int[] dp = new int[n];
        int[] prev = new int[n];
        
        Arrays.fill(prev, -1);
        int max = 0;
        int lastInd = 0;
        for(int i=0;i<n;i++){
            
            for(int j=i-1;j>=0;j--){
                
                if(nums[i]%nums[j] == 0 && dp[i] < dp[j]+1){
                    dp[i] = dp[j]+1;
                    prev[i] = j;
                }
    
            }
            
           if(max < dp[i]){
                    max = dp[i];
                    lastInd = i;
                }
        }
        
        List<Integer> res = new ArrayList<>();
        while(lastInd >= 0){
            
            res.add(nums[lastInd]);
            lastInd = prev[lastInd];
        }
        
        return res;
    }
}