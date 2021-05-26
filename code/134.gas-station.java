class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        
        int currentGaining = 0;
        int totalGaining = 0;
        int candidate = 0;
        
        for(int i= 0; i < gas.length; i++) {
            
            currentGaining += gas[i] - cost[i];
            totalGaining += gas[i] - cost[i];
            
            if (currentGaining < 0) {
                candidate = i+1;
                currentGaining = 0;
            }
            
        }
        
        return totalGaining >= 0 ? candidate : -1;
        
    }
}