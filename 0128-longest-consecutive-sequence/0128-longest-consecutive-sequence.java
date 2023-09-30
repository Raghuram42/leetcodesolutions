class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        
        int ans = 0;
        for(int n:nums){
            set.add(n);
            
            // while()
        }
        
        for(int n: nums){
            int t = 0;
            if(!set.contains(n+1)){
                while(set.contains(n)){
                    n--;
                    t++;
                }
                ans = Math.max(ans, t);
            }
        }
        
        return ans;
    }
}