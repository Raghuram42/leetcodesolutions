class Solution {
    public long numberOfWeeks(int[] milestones) {
        int max = -1;
        long sum = 0;
        for(int i=0;i<milestones.length;i++){
            sum += milestones[i];
            max = Math.max(max, milestones[i]);
        }
        
        
        return Math.min((sum-max)*2+1, sum);
        
        
    }
}
