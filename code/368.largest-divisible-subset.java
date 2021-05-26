class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        if(nums.length==0) return new ArrayList<>();
        int n = nums.length;
        Arrays.sort(nums);
        int[] dp = new int[n];
        Arrays.fill(dp,1);
        int index =0,max=1;
        for(int i = 1;i<n;i++){
            for(int j=0;j<i;j++){
                dp[i] = nums[i]%nums[j]==0?Math.max(dp[i],dp[j]+1):dp[i];
                if(dp[i]>max){
                    index = i;
                    max = dp[i];
                }
            }
        }
        List<Integer> a = new ArrayList<>();
        int last = nums[index];a.add(last);max--;
        for(int i=index-1;i>=0;i--){
            if(last%nums[i]==0&&dp[i]==max){
                a.add(nums[i]);
                max--;
            }
        }
        return a;
    }
}
