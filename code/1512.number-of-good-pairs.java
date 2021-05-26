class Solution {
    public int numIdenticalPairs(int[] nums) {
     int freq[] = new int[1001];   
        
        for(int n: nums){
            freq[n]++;
        }
        int res = 0;
        for(int n: freq){
            if(n>1)
                res += n*(n-1)/2;
        }
        
        return res;
    }
    
}