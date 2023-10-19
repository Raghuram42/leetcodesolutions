class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int curr = 0;
        int st = 0;
        
        int i = 0;
        int n = gas.length;
        int ans = 0;
        while(i<n){
            curr += gas[i]-cost[i];
            
            st += gas[i]-cost[i];
            
            
            if(curr < 0){
                ans = i+1;
                curr = 0;
            }
            i++;
        }
        return st >= 0? ans : -1;
            
    }
}