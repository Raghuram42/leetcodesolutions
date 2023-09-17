class Solution {
    public int sumIndicesWithKSetBits(List<Integer> nums, int k) {
        int ans  = 0;
        
        
        for(int i=0;i<nums.size();i++){
            int v = 0;
            int p = nums.get(i);
            int n = i;
            while(n > 0)
            {
                // System.out.println(n+" "+(n&1)+" "+v);
                v += (n&1);
                n = n/2;
            }
            ans += v == k ? p: 0;
        }
        
        return ans;
    }
}