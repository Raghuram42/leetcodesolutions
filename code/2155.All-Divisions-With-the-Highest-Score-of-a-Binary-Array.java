class Solution {
    public List<Integer> maxScoreIndices(int[] nums) {
        int n = nums.length;
        int[] zeros = new int[n];
        int[] ones = new int[n];
        int maxones = 0;
        int maxZeros = 0;
        for(int i=0;i<n;i++){
            zeros[i] = (i-1 >=0 ? zeros[i-1] : 0 )+(nums[i] == 0 ? 1:0);
        }
        
        
        int maxDiv = 0;
        for(int i=n-1;i>=0;i--){
            ones[i] = (i+1 <n ? ones[i+1] : 0 )+(nums[i] == 1 ? 1:0);
            maxDiv = Math.max(maxDiv, ones[i]+(i-1>=0 ? zeros[i-1]:0));
        }
        // System.out.println(maxDiv+" "+Arrays.toString(zeros)+" "+Arrays.toString(ones));    
        // if(maxDiv >)
        List<Integer> ans = new ArrayList<>();
        
        maxDiv = Math.max(maxDiv, zeros[n-1]);
        for(int i=0;i<n;i++){
            if(ones[i]+(i-1>=0 ? zeros[i-1]:0) == maxDiv)
             ans.add(i);
        }
        
        if(zeros[n-1] == maxDiv)
            ans.add(n);
        return ans;
    }
}
